package com.flowergarden.flowers;

import com.flowergarden.properties.Freshness;

public class FlowerDecorator implements Flower<Integer> {
	
	private Flower<Integer> flower;
	
	public FlowerDecorator(Flower<Integer> f){
		flower = f;
	}
	
	public Freshness<Integer> getFreshness(){
		return flower.getFreshness();
	}
	public float getPrice(){
		return flower.getPrice();
	}
	public int getLenght(){
		return flower.getLenght();
	}

}
