package com.prowings.hibernate.inheritancedemo.table_per_class;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Cacheable
//@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Student extends Person {

	@Column
	private String course;

	public Student(String name, String course) {
		super(name);
		this.course = course;
	}
	
	
}