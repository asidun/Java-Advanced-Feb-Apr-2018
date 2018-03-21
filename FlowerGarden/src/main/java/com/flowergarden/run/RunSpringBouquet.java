package com.flowergarden.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.flowergarden.bouquet.MarriedBouquet;
import com.flowergarden.service.BouquetService;
import com.flowergarden.db.*;
import com.flowergarden.exception.BouquetException;
import com.flowergarden.exception.FlowerException;
import com.flowergarden.exception.FlowerNotFoundException;

public class RunSpringBouquet {

	public static void main(String[] args) throws BouquetException, FlowerNotFoundException, FlowerException {		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context-bouquet.xml");
		BouquetDAO bouquetDAO = ctx.getBean("bouquetDAO", BouquetDAO.class);
		BouquetService bouquetService = ctx.getBean("bouquetService", BouquetService.class);
		System.out.println(bouquetService.getBouquetePrice(bouquetDAO.getMarriedBouquet(1)));

	}

}
