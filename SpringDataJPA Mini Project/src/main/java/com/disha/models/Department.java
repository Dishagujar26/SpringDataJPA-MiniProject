package com.disha.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
      private String name;
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int id;
      @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
      @JoinColumn(name = "dept_id") // FK column in employee
      List<Employee> employees = new ArrayList<>();
      public Department(String name) {
    	  this.name=name;
      }
      public Department() {
    	  
      }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Department [name=" + name + ", id=" + id + "]";
	}
	public List<Employee> getEmpList() {
		return employees;
	}
	public void addEmp(Employee e) {
		this.employees.add(e);
	}
	public void removeEmp(Employee e) {
		this.employees.remove(e);
	}  
      
}
