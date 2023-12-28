package com.jspiders;

public class Student {

	private String id;
	private int age;
	private String name;
	private double marks;
	
	private  static int count= 111;
	 
	public Student(String name,int age, double marks ){
		 this.id ="SRI"+count ;
		 this.name=name;
		 this.age=age;
		 this.marks=marks;
		 count++;
	}
	public String getId() {
		return id;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Student.count = count;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", age=" + age + ", name=" + name + ", marks=" + marks + "]";
	}
	
	
	
}
