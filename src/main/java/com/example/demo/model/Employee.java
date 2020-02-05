package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity

@Table(name = "test")
public class Employee {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

  @Column(name ="name")
	private String name;
  
  @Column(name ="roll")
	private String roll;
  
  @Column(name ="salary")
	private double salary;
  
  
  @Column(name ="profile")
  private String image;
	
	

	public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", roll=" + roll + ", salary=" + salary + "]";
	}
	
	
	
	
	
	
}
