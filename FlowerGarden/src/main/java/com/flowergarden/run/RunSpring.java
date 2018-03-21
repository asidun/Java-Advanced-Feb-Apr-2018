package com.flowergarden.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.flowergarden.run.spring.BankApplication;

public class RunSpring {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		BankApplication bank = ctx.getBean("bankApplication", BankApplication.class);
		System.out.println(bank.getPerson().getCompany().getName());

	}

}
