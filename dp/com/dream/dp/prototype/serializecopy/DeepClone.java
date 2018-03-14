package com.dream.dp.prototype.serializecopy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class DeepClone implements Serializable {

	/**
	 *transient 
	 */
	private static final long serialVersionUID = 1L;
	
	public Object deepClone() throws Exception {
		//串行化serialization
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream oo =new ObjectOutputStream(bo);
		oo.writeObject(this);
		//并行化deserialization
		ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
		ObjectInputStream oi = new ObjectInputStream(bi);
		return oi.readObject();
	}
	public static void main(String[] args) throws Exception {
		DeepClone d = new DeepClone();
		DeepClone dc = (DeepClone) d.deepClone();
		System.out.println(dc.getClass());
	}
}
