package com.flowergarden.json;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

	public Address(String street) {
		super();
		this.street = street;
	}
	
	public Address(){
		
	}

	private String street;
	
}
