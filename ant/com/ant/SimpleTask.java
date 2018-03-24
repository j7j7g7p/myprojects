package com.ant;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

public class SimpleTask extends Task{

	@Override
	public void execute() throws BuildException {
		  System.out.println("Simple  Task!");
	}
}
