
package com.jspiders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.customException.InvalidChoiceException;
import com.customException.StudentNotFoundException;
import com.sortLogic.SortStudentByAge;
import com.sortLogic.SortStudentById;
import com.sortLogic.SortStudentByMarks;
import com.sortLogic.SortStudentByName;


public class StudentManagementSystemImpl implements StudentManagementSystem{


	Map<String , Student> db= new LinkedHashMap<>();
	Scanner sc =new Scanner(System.in);
	
	
	@Override
	public void addStudent() {
		System.out.println("Enter  Name");
		String Name=sc.next();
		System.out.println("Enter  Age");
		int age= sc.nextInt();
		System.out.println("Enter  Marks");
		double marks= sc.nextDouble();

		Student s= new Student(Name,age,marks);
		db.put(s.getId(), s);

		System.out.println("Student Record Inserted SuccessFully");
		System.out.println("Your Student Id is "+s.getId());
	}

	@Override
	public void displayStudent() {


		System.out.println("Enter StudentId ");
		String id = sc.nextLine();
		id=id.toUpperCase();
		if( db.containsKey(id)) {
			Student obj= db.get(id);
			System.out.println("Id : "+obj.getId());
			System.out.println("Name : "+obj.getName());
			System.out.println("Age : "+obj.getAge());
			System.out.println("MArks : "+obj.getMarks());
			
		}
		else {
			try {
				throw new StudentNotFoundException("Student Record Not Available");
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}



	}

	@Override
	public void displayAllStudent() {

		Set<String> keys=db.keySet();		 
		System.out.println("Student Records are as Follows: ");
		System.out.println("------------------------------");
		if(db.size() != 0) {

			for(String key:keys) {
				System.out.println(db.get(key)); 			
			}
		}
		else {

			try {
				throw new StudentNotFoundException("Student Record Not Available");
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeStudent() {

		System.out.println("ENter Studnet ID: ");
		String id=sc.next().toUpperCase();
		if(db.containsKey(id)) {
			db.remove(id);
			System.out.println("Student Record Deleted Succesfully");
		}
		else {
			try {
				throw new StudentNotFoundException("Student Records Not Found");
			}
			catch (Exception e) {
				String message=e.getMessage();
				System.out.println(message);
			}
		}
	}

	@Override
	public void removeAllStudent() {

		System.out.println("Total Students Records Avaialble: "+db.size());
			db.clear();
			System.out.println(" All Student Records Deleted Successfully");
		
	}

	@Override
	public void updateStudent() {

		System.out.println("Enter Student ID:");
		String id=sc.next().toUpperCase();
		
		if(db.containsKey(id)) {
			Student s=db.get(id);
			System.out.println("1:UpdateStudent name\n2:UpdateStudent Age");
			System.out.println("3:Update Student Marks");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Name: ");
				String name=sc.next();
				s.setName(name);	
				System.out.println("Name updated Successfully ");
				break;
			case 2:
				System.out.println("Enter Age: ");
				int Age=sc.nextInt();
				s.setAge(Age);	
				System.out.println("Age updated Successfully ");
				break;
			case 3:
				System.out.println("Enter Marks: ");
				double Marks=sc.nextDouble();
				s.setMarks(Marks);	
				System.out.println("MArks updated Successfully ");
				break;
			default:	
				try {
					throw new InvalidChoiceException("Invalid Choice\n Kindly choice from above");
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try {
				throw new StudentNotFoundException("Student Records Not Found");
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void countStudent() {
		System.out.println("Total Number of Students Records: "+db.size());
	}

	@Override
	public void sortStudents() {
		
		 
		Set<String> keys=db.keySet();	
		List<Student>  list=new ArrayList<Student>();
		
		for (String key : keys) {
									
			list.add(db.get(key));
		}
		
		System.out.println("1:sort By Id\n2:Sort By Name");
		System.out.println("3:Sort By marks\n4:Sort By Age\nEnter Choice:");
		int chioce =sc.nextInt();
		switch (chioce) {
		case 1:
			Collections.sort(list,new SortStudentById());
			display(list);
		
			break;
		case 2:
			Collections.sort(list,new SortStudentByName());
			display(list);
			break;
		case 3:
			Collections.sort(list,new SortStudentByMarks());
			display(list);
			break;
		case 4:
			Collections.sort(list,new SortStudentByAge());
			display(list);
			break;
		
			
		default:
			try {
				throw new InvalidChoiceException("Invalid Choice !");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		
	}
	private static void display(List<Student> list) {
		for(Student s:list) {
			System.out.println(s);
		}
	}
	

}
