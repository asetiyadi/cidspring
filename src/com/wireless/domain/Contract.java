package com.wireless.domain;

import java.io.Serializable;
import java.math.BigInteger;

public class Contract implements Serializable 
{
	private static final long serialVersionUID = -294438415905680624L;
	
	private BigInteger term;
	private String locationId;
	private String salesRepresentative;
	private String salesChannel;

	public BigInteger getTerm() {
		return term;
	}

	public void setTerm(BigInteger term) {
		this.term = term;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getSalesRepresentative() {
		return salesRepresentative;
	}

	public void setSalesRepresentative(String salesRepresentative) {
		this.salesRepresentative = salesRepresentative;
	}

	public String getSalesChannel() {
		return salesChannel;
	}

	public void setSalesChannel(String salesChannel) {
		this.salesChannel = salesChannel;
	}

	@Override
	public String toString() {
		return "Contract [term=" + term + ", locationId=" + locationId
				+ ", salesRepresentative=" + salesRepresentative
				+ ", salesChannel=" + salesChannel + "]";
	}
}
