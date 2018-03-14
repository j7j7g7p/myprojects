package com.dream.dp.factory.factorymethod;

import com.dream.dp.factory.simplefactory.Fruit;
import com.dream.dp.factory.simplefactory.Grape;

public class GrapeGardenner extends AbstractGardenner {

	@Override
	Fruit createFriut() {
		return new Grape();
	}

}
