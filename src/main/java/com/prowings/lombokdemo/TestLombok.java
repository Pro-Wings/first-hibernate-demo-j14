package com.prowings.lombokdemo;

public class TestLombok {
	
	public static void main(String[] args) {
		
//		Employee emp = new Employee(10, "Ram", "IT", 1231.23);
		Employee emp = new Employee();
		
		System.out.println(emp.getName());
		
		System.out.println(emp);
		
		
	}

}
