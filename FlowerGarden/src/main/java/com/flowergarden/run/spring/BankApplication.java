package com.flowergarden.run.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankApplication {
	@Autowired
	private Person person;

	public void setCompanyReport(){
	}

	public Person getPerson(){
		return person;
	}
	
	public void setPerson(Person person){
		this.person = person;
	}

}
