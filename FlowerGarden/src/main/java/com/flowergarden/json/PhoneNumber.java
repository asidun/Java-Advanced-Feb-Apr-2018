package com.flowergarden.json;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;


@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneNumber {

	public PhoneNumber(String type, String number) {
		super();
		this.type = type;
		this.number = number;
	}

	public PhoneNumber() {
	}
	
	@XmlAttribute
	private String type;
	
	@XmlValue
	private String number;

	
}
