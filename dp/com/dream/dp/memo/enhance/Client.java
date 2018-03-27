package com.dream.dp.memo.enhance;

public class Client {
	public static void main(String[] args) {
		Originator originator = new Originator();
		originator.setState(0, "html");
		originator.setState(1, "java");
		originator.setState(2, "js");
		originator.setState(3, "jq");
		Caretaker caretaker = new Caretaker(originator);
		originator.setState(4, "c+");
		caretaker.restoreMemo(4);
	}
}

