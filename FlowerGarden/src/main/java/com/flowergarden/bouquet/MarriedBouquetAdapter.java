package com.flowergarden.bouquet;

import java.util.Collection;

import com.flowergarden.flowers.GeneralFlower;

public class MarriedBouquetAdapter extends MarriedBouquet implements MarriedBouquetLongerThan {

	@Override
	public Collection<GeneralFlower> searchFlowersLongerThen(int start) {
		return searchFlowersByLenght(start, Integer.MAX_VALUE);
	}

}
