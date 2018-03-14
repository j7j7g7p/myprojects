package com.dream.dp.composite.safe;

public class Leaf implements Component {
	@Override
	public Component getComposite() {
		return this;
	}

	@Override
	public void sampleOperation() {
			
	}

}
