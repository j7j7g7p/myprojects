package com.dream.dp.factory.factorymethod;

import com.dream.dp.factory.simplefactory.Fruit;
import com.dream.dp.factory.simplefactory.Strawberry;

public class StrawberryGardenner extends AbstractGardenner {

	@Override
	Fruit createFriut() {
		return new Strawberry();
	}

}
