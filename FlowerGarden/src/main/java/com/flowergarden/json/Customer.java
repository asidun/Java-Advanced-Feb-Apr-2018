package com.flowergarden.json;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class Customer {
 
	@XmlTransient
    private int id;

	public Customer(int id, String firstName, String lastName, Address address, List<PhoneNumber> phoneNumbers) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumbers = phoneNumbers;
	}
    
    public Customer(){
    	
    }

	@XmlElement(name="first-name")
    private String firstName;
 
    @XmlElement(name="last-name")
    private String lastName;
  
    private Address address;
 
    @XmlElement(name="phone-number")
    private List<PhoneNumber> phoneNumbers;
 
}

