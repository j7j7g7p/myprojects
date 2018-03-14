package com.dream.dp.composite.safe;

import java.util.Enumeration;
import java.util.Vector;

public class Composite implements Component{
	private Vector<Component> componentVector = new Vector<>();
	@Override
	public Component getComposite() {
		return this;
	}

	@Override
	public void sampleOperation() {
		Enumeration<Component> enumeration = components();
		while (enumeration.hasMoreElements()) {
			((Component) enumeration.nextElement()).sampleOperation();
			
		}
			
	}
	
	public void add(Component component) {
		componentVector.addElement(component);
	}
	
	public void remove(Component component) {
		componentVector.removeElement(component);
	}
	
	public Enumeration<Component> components() {
		return componentVector.elements();
	}
	
}
