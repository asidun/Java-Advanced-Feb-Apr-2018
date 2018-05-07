package com.flowergarden.flowers;

import com.flowergarden.bouquet.IPrice;
import com.flowergarden.properties.Freshness;

public interface Flower<T> extends IPrice {
	Freshness<T> getFreshness();
	float getPrice();
	int getLenght();
}
