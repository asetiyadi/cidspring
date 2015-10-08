package com.wireless.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Properties;
import java.util.UUID;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.message.MessageElement;
import org.apache.axis.message.SOAPHeaderElement;

import com.cricket.esp.ESP.Namespaces.Container.Public.MessageHeader_xsd.MessageHeaderInfo;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.MessageHeaderSecurity;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.MessageHeaderSequence;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.MessageHeaderTracking;
import com.cricket.esp.ESP.Namespaces.Types.Public.CricketDataModel_xsd.MessageHeaderTrackingVersion;
import com.cricket.esp.ESP.Namespaces.v1.wsdl.Cricket_ESP_HTTP_wsdl.CricketESPHTTPServicesLocator;


public class ESPHelper {
	
	private CricketESPHTTPServicesLocator esp_service; 
	private SOAPHeaderElement header;
	private Properties properties = new Properties();

	private String endPoint;// 	   	= Config.get( "tibco_esp.endpoint" );
	private String portAddress;// 	= Config.get( "tibco_esp.port_address" );
	
	public ESPHelper() {
		super();
		
		try 
		{
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("com/wireless/web/config/id.properties");
			properties.load(inputStream);
			
			String environment = properties.getProperty("app_environment");
			inputStream = getClass().getClassLoader().getResourceAsStream("com/wireless/web/config/" + environment + ".properties");
			properties.load(inputStream);
			
			this.endPoint = (String) properties.get("tibco_esp.endpoint");
			this.portAddress = (String) properties.get("tibco_esp.port_address");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	/***
	 * Creating MessageHeader
	 * @return SOAPHeaderElement
	 * @throws Exception
	 */
	public SOAPHeaderElement createMessageHeader() throws Exception	{ 
		this.header = getSoapHeader( getTransactionID() );
		
		return this.header;
	}
	
	/**
	 * Get unique transactionId
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String getTransactionID() throws Exception	{
		java.util.Date today = new java.util.Date(); 
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss");
		String ts = sdf.format(today);
				
		String transactionID = "LCDS-" + getClientName() + "-" + ts + "-" + UUID.randomUUID().toString();
		
		return transactionID;
	}
	
	/**
	 * Get machine name
	 * 
	 * @return String
	 * @throws Exception
	 */
	private String getClientName() throws Exception		{
		String clientName = "";
		
		try	{
			InetAddress addr = InetAddress.getLocalHost();
			clientName = addr.getHostName();
		}
		catch(UnknownHostException e){
			throw new Exception( "Cannot get hostname:" + e.getMessage() );
		}
		
		return clientName;
	}
	
	/**
	 * Get ESP SOAP header element
	 * 
	 * @param transactionID String
	 * @return SOAPHeaderElement
	 */
	public SOAPHeaderElement getSoapHeader(String transactionID){
		int timeout = 300000;
		
		return getSoapHeader(transactionID, Integer.toString(timeout), (String) properties.get("tibco_esp.username"), (String) properties.get( "tibco_esp.password" ));
	}
	
	/**
	 * Get ESP SOAP header
	 * 
	 * @param messageId String
	 * @param ttl String
	 * @param userName String
	 * @param password String
	 * @return SOAP header
	 */
	public SOAPHeaderElement getSoapHeader(String messageId, String ttl, String userName, String password)		{
		QName header_name = getMessageHeaderQname();
		MessageHeaderInfo header = getMessageHeader(messageId, ttl,userName,password);
		SOAPHeaderElement temp = new SOAPHeaderElement(header_name,header);

		return temp;
	}
	
	/**
	 * Get message header qname
	 * 
	 * @return qname
	 */
	private QName getMessageHeaderQname(){
		return new QName("http://esp.cricket.com/ESP/Namespaces/Container/Public/MessageHeader.xsd","MessageHeader");
	}
	
	/**
	 * Get ESP message header
	 * 
	 * @param messageId String
	 * @param ttl String
	 * @param userName String
	 * @param password String
	 * @return Message header
	 */
	private MessageHeaderInfo getMessageHeader(String messageId, String ttl, String userName, String password){
		MessageHeaderInfo temp = new MessageHeaderInfo();
		
		
		
		//Create tracking message header
		MessageHeaderTracking mht = new MessageHeaderTracking();
		mht.setVersion(MessageHeaderTrackingVersion.v1);
		mht.setMessageId(messageId);
		mht.setTimeToLive(new java.math.BigInteger(ttl));
		mht.setDateTimeStamp(new GregorianCalendar());
		temp.setTrackingMessageHeader(mht);

		//Create security message header
		MessageHeaderSecurity mhs = new MessageHeaderSecurity();
		mhs.setUserName(userName);
		mhs.setUserPassword(password);
		temp.setSecurityMessageHeader(mhs);

		//Create sequence message header
		MessageHeaderSequence mhsq = new MessageHeaderSequence();
		mhsq.setSequenceNumber("1");
		mhsq.setTotalInSequence("1");
		temp.setSequenceMessageHeader(mhsq);

		return temp;
	}
	
	/***
	 * Set service endpoint
	 * 
	 * @param serviceName String
	 * @return CricketESPHTTPServicesLocator
	 */
	public CricketESPHTTPServicesLocator setService(String serviceName)
	{
		this.esp_service = new CricketESPHTTPServicesLocator();
		
		try {
			this.esp_service.setEndpointAddress(serviceName, this.portAddress);
		} 
		catch (ServiceException e) {

		}
		
		return esp_service;
	}
	
	/***
	 * Set URL endPoint
	 * 
	 * @param serviceName String
	 * @return URL
	 * @throws Exception
	 */
	public URL getEndPoint( String serviceName ) throws Exception	{
		java.net.URL named_endpoint; 

		try {
			named_endpoint = new java.net.URL(this.endPoint + serviceName);
		} catch (MalformedURLException e) {
			throw new Exception("Error creating named endpoint with endpoint => " + this.endPoint + " and service name => " + serviceName );
		}
		
		return named_endpoint;
	}
	
	/***
	 * Extract conversationId from ESP Response Header
	 * 
	 * @param headers An array of SOAPHeaderElement
	 * @return String
	 */
	public String getConversationId( SOAPHeaderElement[] headers ) 	{
		String conversationId = "";
		
		Iterator<?> iterator = headers[0].getChildElements();

		while( iterator.hasNext() ) 	{
			MessageElement messageHeader = (MessageElement) iterator.next();
			if( messageHeader.getName().equalsIgnoreCase( "TrackingMessageHeader" ))	{
				Iterator<?> itMessageHeader = messageHeader.getChildElements();
				while( itMessageHeader.hasNext() )	{
					MessageElement element = (MessageElement) itMessageHeader.next();
					if( element.getName().equalsIgnoreCase( "conversationId" ))	{
						conversationId = element.getValue();
						break;
					}
				}
				break;
			}
		}
		
		return conversationId;
	}
}

