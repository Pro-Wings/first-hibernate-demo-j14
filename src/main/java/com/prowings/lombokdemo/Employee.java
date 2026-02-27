package com.prowings.lombokdemo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

//@Data --
@RequiredArgsConstructor
public class Employee {
	
	private final int empId;
	private String name;
	private String department;
	private double salary;
}
