package com.dream.dp.factory.factorymethod;

import com.dream.dp.factory.simplefactory.Apple;
import com.dream.dp.factory.simplefactory.Fruit;

public class AppleGarden extends AbstractGardenner {

	@Override
	Fruit createFriut() {
		return new Apple();
	}


}
