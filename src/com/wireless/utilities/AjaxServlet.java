package com.wireless.utilities;

import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class AjaxServlet
 */
public class AjaxServlet extends HttpServlet {
	/*
	private static final long serialVersionUID = 1L;
    private WebApplicationContext context;
    
    public AjaxServlet() {
        super();
    }

    @Override
    public void init(ServletConfig servletConfig)
    {
    	this.context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletConfig.getServletContext());
    	
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		
		Map<String, String> result = new HashMap<String, String>();
		
		UtilityService utilities = (UtilityService) this.context.getBean("utilities");
				
		if(method.equalsIgnoreCase("cityStateByZip"))
		{
			result = utilities.getCityStateByZip(request.getParameter("zipcode"));
		}
		
		String json = prepareOutput(result);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.write(json);
	}
		
	private String prepareOutput(Map<String, String> result)
	{
		String json = null;
		json = new Gson().toJson(result);
		
		return json;
	}
	*/
}
