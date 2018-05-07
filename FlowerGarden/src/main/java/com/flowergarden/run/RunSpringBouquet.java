package com.flowergarden.run;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.flowergarden.bouquet.Bouquet;
import com.flowergarden.bouquet.IPrice;
import com.flowergarden.bouquet.MarriedBouquet;
import com.flowergarden.service.BouquetService;
import com.flowergarden.db.*;
import com.flowergarden.exception.BouquetException;
import com.flowergarden.exception.FlowerException;
import com.flowergarden.exception.FlowerNotFoundException;
import com.flowergarden.flowers.GeneralFlower;

public class RunSpringBouquet {

	public static void main(String[] args) throws BouquetException, FlowerNotFoundException, FlowerException {		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context-bouquet.xml");
		BouquetDAO bouquetDAO = ctx.getBean("bouquetDAO", BouquetDAO.class);
		FlowerDAO flowerDAO = ctx.getBean("flowerDAO", FlowerDAO.class);
		BouquetService bouquetService = ctx.getBean("bouquetService", BouquetService.class);
		IPrice bouquetPrice = bouquetDAO.getMarriedBouquet(1);
		Bouquet<GeneralFlower> bouq = (Bouquet<GeneralFlower>) bouquetPrice; 
		IPrice flower1Price = flowerDAO.getFlowerById(1);
		List<IPrice> priceList = (List) bouq.getFlowers();
		
		priceList.add(bouquetPrice);
		for (IPrice fPrice : priceList) {
			System.out.println(fPrice.getPrice());
		}
		

	}

}
