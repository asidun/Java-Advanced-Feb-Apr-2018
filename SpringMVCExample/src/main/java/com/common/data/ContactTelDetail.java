package com.common.data;


public class ContactTelDetail {

	private int id;
	private int contactId;
	private TelType telType;
	private String telNumber;
	private int version;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TelType getTelType() {
		return telType;
	}
	public void setTelType(TelType telType) {
		this.telType = telType;
	}
	public void setTelType(String type) {
		this.telType = TelType.valueOf(type);		
	}
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	
	
}
