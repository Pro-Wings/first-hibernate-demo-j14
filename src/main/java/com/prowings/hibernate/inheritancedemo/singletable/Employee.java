package com.prowings.hibernate.inheritancedemo.singletable;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("EMPLOYEE-RECORD")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee extends Person {
	@Column
    private double salary;

	public Employee(String name, double salary) {
		super(name);
		this.salary = salary;
	}
	
}