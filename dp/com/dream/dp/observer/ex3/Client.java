package com.dream.dp.observer.ex3;

public class Client {
	public static void main(String[] args) {
		Watched watched = new Watched();
		Watcher watcher = new Watcher(watched);
		
		watched.changeData("hello world!");
		watched.changeData("hello java");
		watched.changeData("hello java");
		watched.changeData("hello php");
		boolean hasChanged = watched.hasChanged();
		System.out.println(hasChanged);
	}
}
