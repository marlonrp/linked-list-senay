package main;

public class Person {
	
	private String name;
	private int age;
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return "{" + this.name + " - " + this.age + "}";
	}
}
