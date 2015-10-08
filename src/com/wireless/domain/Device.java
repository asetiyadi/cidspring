package com.wireless.domain;

import java.io.Serializable;
import java.util.Arrays;

import com.wireless.bean.DeviceHistoryBean;
import com.wireless.bean.NetworkProviderBean;

//import com.cricket.cid.exception.bean.ApplicationErrorBean;

public class Device implements Serializable 
{
	private static final long serialVersionUID = -7846278048949571225L;

	private boolean cpe;
	private String mdn;
	private String esn;
	private String meid;
	private String imei;
	private boolean hasEsnHistory;
	private String imsi;
	private boolean isCricketPhone;
	private String min;
	private boolean tradeInHandset;
	private String make;
	private String model;
	private String deviceCode;
	private String deviceType = "Voice";
	private String deviceId;
	private DeviceHistoryBean[] deviceHistory;
	private String deviceStatus;
	private boolean isBBMM;
	private boolean isPaygo;
	private boolean isRefurbished;
	private Integer externalRetailerId;
	private String externalRetailerName;
	private String accountNumber;
	private NetworkProviderBean[] networkProvider;
	// private ApplicationErrorBean applicationErrorBean;
	private String ICCID;
	private String sf_eumid;
	private String encryptionKey;
	private String puk1;
	private String imeisv;

	public boolean isCpe() {
		return cpe;
	}

	public void setCpe(boolean cpe) {
		this.cpe = cpe;
	}

	public String getMdn() {
		return mdn;
	}

	public void setMdn(String mdn) {
		this.mdn = mdn;
	}

	public String getEsn() {
		return esn;
	}

	public void setEsn(String esn) {
		this.esn = esn;
	}

	public String getMeid() {
		return meid;
	}

	public void setMeid(String meid) {
		this.meid = meid;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public boolean isHasEsnHistory() {
		return hasEsnHistory;
	}

	public void setHasEsnHistory(boolean hasEsnHistory) {
		this.hasEsnHistory = hasEsnHistory;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public boolean isCricketPhone() {
		return isCricketPhone;
	}

	public void setCricketPhone(boolean isCricketPhone) {
		this.isCricketPhone = isCricketPhone;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public boolean isTradeInHandset() {
		return tradeInHandset;
	}

	public void setTradeInHandset(boolean tradeInHandset) {
		this.tradeInHandset = tradeInHandset;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public DeviceHistoryBean[] getDeviceHistory() {
		return deviceHistory;
	}

	public void setDeviceHistory(DeviceHistoryBean[] deviceHistory) {
		this.deviceHistory = deviceHistory;
	}

	public String getDeviceStatus() {
		return deviceStatus;
	}

	public void setDeviceStatus(String deviceStatus) {
		this.deviceStatus = deviceStatus;
	}

	public boolean isBBMM() {
		return isBBMM;
	}

	public void setBBMM(boolean isBBMM) {
		this.isBBMM = isBBMM;
	}

	public boolean isPaygo() {
		return isPaygo;
	}

	public void setPaygo(boolean isPaygo) {
		this.isPaygo = isPaygo;
	}

	public boolean isRefurbished() {
		return isRefurbished;
	}

	public void setRefurbished(boolean isRefurbished) {
		this.isRefurbished = isRefurbished;
	}

	public Integer getExternalRetailerId() {
		return externalRetailerId;
	}

	public void setExternalRetailerId(Integer externalRetailerId) {
		this.externalRetailerId = externalRetailerId;
	}

	public String getExternalRetailerName() {
		return externalRetailerName;
	}

	public void setExternalRetailerName(String externalRetailerName) {
		this.externalRetailerName = externalRetailerName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public NetworkProviderBean[] getNetworkProvider() {
		return networkProvider;
	}

	public void setNetworkProvider(NetworkProviderBean[] networkProvider) {
		this.networkProvider = networkProvider;
	}

	public String getICCID() {
		return ICCID;
	}

	public void setICCID(String iCCID) {
		ICCID = iCCID;
	}

	public String getSf_eumid() {
		return sf_eumid;
	}

	public void setSf_eumid(String sf_eumid) {
		this.sf_eumid = sf_eumid;
	}

	public String getEncryptionKey() {
		return encryptionKey;
	}

	public void setEncryptionKey(String encryptionKey) {
		this.encryptionKey = encryptionKey;
	}

	public String getPuk1() {
		return puk1;
	}

	public void setPuk1(String puk1) {
		this.puk1 = puk1;
	}

	public String getImeisv() {
		return imeisv;
	}

	public void setImeisv(String imeisv) {
		this.imeisv = imeisv;
	}

	@Override
	public String toString() {
		return "Device [cpe=" + cpe + ", mdn=" + mdn + ", esn=" + esn
				+ ", meid=" + meid + ", imei=" + imei + ", hasEsnHistory="
				+ hasEsnHistory + ", imsi=" + imsi + ", isCricketPhone="
				+ isCricketPhone + ", min=" + min + ", tradeInHandset="
				+ tradeInHandset + ", make=" + make + ", model=" + model
				+ ", deviceCode=" + deviceCode + ", deviceType=" + deviceType
				+ ", deviceId=" + deviceId + ", deviceHistory="
				+ Arrays.toString(deviceHistory) + ", deviceStatus="
				+ deviceStatus + ", isBBMM=" + isBBMM + ", isPaygo=" + isPaygo
				+ ", isRefurbished=" + isRefurbished + ", externalRetailerId="
				+ externalRetailerId + ", externalRetailerName="
				+ externalRetailerName + ", accountNumber=" + accountNumber
				+ ", networkProvider=" + Arrays.toString(networkProvider)
				+ ", ICCID=" + ICCID + ", sf_eumid=" + sf_eumid
				+ ", encryptionKey=" + encryptionKey + ", puk1=" + puk1
				+ ", imeisv=" + imeisv + "]";
	}	
}
