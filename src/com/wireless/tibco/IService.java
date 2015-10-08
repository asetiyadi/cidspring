package com.wireless.tibco;

import java.util.HashMap;


/**
 * Interface to be implemented for ESP webservice class
 *
 */
public interface IService {
	
	/**
	 * @return ESP service name 
	 */
	String getServiceName();
	
	/**
	 * @return ESP response info object
	 * @throws Exception 
	 */
	HashMap< String, Object > invokeService() throws Exception;
	
	/**
	 * Create the webservice request
	 */
	void createRequest();
	
	/**
	 * Create the webservice stub
	 */
	void createStub() throws Exception;
}
