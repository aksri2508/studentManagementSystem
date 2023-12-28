package com.example;

public class Employee {

	
	 String id;
	 String name;
	static  int count=101;
	
	  Employee(String name){
		this.id ="SRI"+count;
		 this.name=name;
		 count++;
	 }
	  
	  
	public static void main(String[] args) {
		
		Employee e1=new Employee("dilli");
		System.out.println("Emp id of "+e1.name+" is "+e1.id);
		Employee e2=new Employee("pavan");
		System.out.println("Emp id of "+e2.name+" is "+e2.id);
		Employee e3=new Employee("vasu");
		System.out.println("Emp id of "+e3.name+" is "+e3.id);
	}

}
