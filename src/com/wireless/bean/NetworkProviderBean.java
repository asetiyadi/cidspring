package com.wireless.bean;

import java.io.Serializable;

public class NetworkProviderBean implements Serializable 
{
	private static final long serialVersionUID = 6060019858715563867L;

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "NetworkProviderBean [id=" + id + ", name=" + name + "]";
	}
}
