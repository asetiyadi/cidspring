package com.wireless.bean;

public class ResponseBean 
{
	private Object object;
	private int code;
	private String description;
	private String className;

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "ResponseBean [object=" + object + ", code=" + code
				+ ", description=" + description + "]";
	}
}
