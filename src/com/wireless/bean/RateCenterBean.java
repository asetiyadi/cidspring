package com.wireless.bean;

import java.io.Serializable;
import java.util.Date;

public class RateCenterBean implements Serializable {
	private static final long serialVersionUID = -8028462483711180627L;

	private String id;
	private String name;
	private String description;
	private String npa;
	private Date effectiveDate;
	//private ApplicationErrorBean applicationErrorBean;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNpa() {
		return npa;
	}
	public void setNpa(String npa) {
		this.npa = npa;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/*public ApplicationErrorBean getApplicationErrorBean() {
		return applicationErrorBean;
	}
	public void setApplicationErrorBean(ApplicationErrorBean applicationErrorBean) {
		this.applicationErrorBean = applicationErrorBean;
	}
	*/
}
