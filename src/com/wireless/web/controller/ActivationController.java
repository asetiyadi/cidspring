package com.wireless.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wireless.bean.OffersBean;
import com.wireless.bean.ProductBean;
import com.wireless.bean.RateCenterBean;
import com.wireless.domain.Account;
import com.wireless.domain.Cart;
import com.wireless.domain.Contract;
import com.wireless.domain.Customer;
import com.wireless.domain.Device;
import com.wireless.domain.UserBean;
import com.wireless.services.AccountService;
import com.wireless.services.ActivationService;
import com.wireless.services.DeviceService;
import com.wireless.services.ParcService;
import com.wireless.services.PaymentService;
import com.wireless.utilities.Utility;

@Controller
@SessionAttributes({"account", "cart"})
public class ActivationController 
{
	@Autowired
	private ActivationService activationService;
	
	@Autowired
	private DeviceService deviceService;
	
	@Autowired
	private ParcService parcService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private AccountService accountService;
	
	//private static Logger logger = Logger.getLogger(ActivationController.class);
	
	@RequestMapping(value="/customerInfo", method=RequestMethod.POST)
	public String showCustomerInfo(@ModelAttribute("user") UserBean user, Model model, HttpSession userSession)
	{
		Account account = new Account();
		Customer customer = new Customer();
		
		account.setCustomer(customer);
		account.setEffectiveDate( new Date() );
		
		model.addAttribute("account", account);

		return "account/customerInfo";
	}
	
	@RequestMapping(value="/losSetup", method=RequestMethod.POST)
	public String showLosSetup(Model model, Account account, BindingResult result, HttpSession userInfo)
	{
		if(result.hasErrors())	
		{
			System.out.println(result.toString());
			return "account/customerInfo";
		}
		else
		{
			String marketId = Utility.getNetworkCoverage(account.getCustomer().getAddress()).get("marketId");
			account.setMarketId(marketId);

			model.addAttribute("account", account);
			model.addAttribute("formAction", "losSetup/validateDevice");
		}

		return "activation/losSetup";
	}
	
	@RequestMapping(value = "/losSetup/validateDevice", method = RequestMethod.POST)
	public String validateDevice(@ModelAttribute("account") Account account, BindingResult result, Model model, HttpSession session)
	{
		System.out.println("lossetup/validateDevice");
		
		String deviceId = account.getSubscriber(0).getDevice().getDeviceId();
		 
		Device device = deviceService.validateDevice(deviceId, account.getMarketId());
		account.getSubscriber(0).setDevice(device);
		
		// Get Products
		List<ProductBean> products = parcService.getProducts(account, ((UserBean) session.getAttribute("user")).getChannelType(), device.getDeviceType());
		
		// Get RateCenter
		RateCenterBean[] rcBeans = Utility.getRateCenterInfo(account.getMarketId());
		
		model.addAttribute("products", products);
		model.addAttribute("rateCenters", rcBeans);
		model.addAttribute("formAction", "offers");

		return "activation/losSetup";
	}
	
	@RequestMapping(value = "/offers", method = RequestMethod.POST)
	public String showOffers(@ModelAttribute("account") Account account, Model model, HttpServletRequest request, HttpSession userInfo) throws Exception
	{
		if(request.getParameter("phoneModel") != null)
		{
			account.getSubscriber(0).getDevice().setDeviceCode(request.getParameter("phoneModel"));
			account.getSubscriber(0).getDevice().setDeviceType("Voice");
		}
		
		System.out.println(account.getSubscriber(0).getDevice().toString());
		
		String accountType;
		
		//for now "S" customer type only
		account.getCustomer().setCustomerType('S');
		
		switch(account.getProductCode())
		{
			case 1:
				accountType = "P";
				break;
				
			case 4:
				accountType = "O";
				break;
				
			default:
				accountType = "P";
		}
		
		UserBean user = (UserBean) userInfo.getAttribute("user");
		
		Contract contract = new Contract();
		contract.setLocationId(user.getLocationId());
		contract.setSalesRepresentative(user.getUserName());
		contract.setSalesChannel(user.getChannelType());
		account.getSubscriber(0).setContract(contract);
		
		account.setAccountType(accountType);
		account.setRateCenterId(Integer.parseInt(request.getParameter("rateCenterOptions")));
		
		Cart cart = new Cart();
		cart.setAccount(account);
		cart.setTransactionType(Cart.TRANSACTION_TYPE_NEW);
		
		OffersBean[] offers = parcService.getOffers(account, 0, user.getChannelType());
		
		
		
		model.addAttribute("cart", cart);
		model.addAttribute("offers", offers);
		
		return "account/offers";
	}
	
	@RequestMapping(value = "/quote", method = RequestMethod.POST)
	public String getQuote(@ModelAttribute("cart") Cart cart, Model model, HttpServletRequest request, HttpSession userInfo)
	{
		try 
		{
			// Set offering codes (ratePlan and features)
			activationService.setSubscribersOfferingCodes(cart.getAccount().getSubscribers(), 0, request);
			
			// Create quote - this will return the reference back to the Cart object
			activationService.createQuote(cart);
			
			UserBean user = (UserBean) userInfo.getAttribute("user");
			cart.getBillingQuote().setLocationId(user.getLocationId());
			cart.getBillingQuote().setSalesChannel(user.getChannelType());
			cart.getBillingQuote().setSalesRepresentative(user.getUserName());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		model.addAttribute("cart", cart);
		
		return "account/quote";
	}
	
	@RequestMapping(value="/payment", method = RequestMethod.POST)
	public String showPayment(@ModelAttribute("cart") Cart cart, Model model)
	{
		model.addAttribute("cart", cart);
		
		return "payment/payment";
	}
	
	@RequestMapping(value="/paymentConfirmation", method = RequestMethod.POST)
	public String showPaymentConfirmation(@ModelAttribute("cart") Cart cart, Model model)
	{
		System.out.println(cart.getPayment().getCreditCard().toString());
		
		// Submit payment
		paymentService.submitPayment(cart);
		
		model.addAttribute("cart", cart);
		
		return "payment/paymentConfirmation";
	}
	
	@RequestMapping(value="/confirmation", method = RequestMethod.POST)
	public String showConfirmation(@ModelAttribute("cart") Cart cart, Model model)
	{
		// Update quote
		accountService.updateQuoteStatus(cart);
		
		// Submit payment
		paymentService.completePayment(cart);
				
		model.addAttribute("cart", cart);
		
		return "account/confirmation";
	}
}
