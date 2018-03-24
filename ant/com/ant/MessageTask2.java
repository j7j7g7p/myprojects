package com.ant;

import org.apache.tools.ant.Task;

public class MessageTask2 extends Task{

    private String message = "";

    public void addText(String message){
           this.message = message;
    }

	public void execute(){
		log(getProject( ).replaceProperties(message));
	}

}
