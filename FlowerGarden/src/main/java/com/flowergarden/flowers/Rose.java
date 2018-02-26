package com.flowergarden.flowers;

import javax.xml.bind.annotation.XmlRootElement;

import com.flowergarden.properties.FreshnessInteger;

@XmlRootElement
public class Rose extends GeneralFlower {
	
	private boolean spike;
	
	public Rose(boolean spike, int lenght, float price, FreshnessInteger fresh){
		this.spike = spike;
		this.lenght = lenght;
		this.price = price;
		this.freshness = fresh;
	}
	public Rose(){
		
	}
	
	public boolean getSpike(){
		return spike;
	}
	


}
