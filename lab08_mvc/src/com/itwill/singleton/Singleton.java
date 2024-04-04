package com.itwill.singleton;

public enum Singleton {
	INSTNACE; // public static final Singleton INSTANCE = new Singleton();
	
	private String name;
	
	Singleton() {
		this.name = "헐크";
	}
	
	public String getName() {
		return this.name;
	}

	public void serName(String name) {
		this.name = name;
	}
}
