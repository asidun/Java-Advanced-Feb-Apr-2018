package com.common;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.common.data.Contact;
import com.common.data.ContactTelDetail;

public class App {
	
	private static final Logger logger = Logger.getLogger(App.class);
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		logger.info("Config is loaded");
		Contact contact1 = (Contact) context.getBean("contact1");
		System.out.println(contact1.getHobbies());
		
		System.out.println(contact1.getTelDetails().get(0).getTelNumber());
		
		ContactTelDetail detail1 = (ContactTelDetail)context.getBean("detail1");
		
		System.out.println(detail1.getTelNumber());
	}
}
