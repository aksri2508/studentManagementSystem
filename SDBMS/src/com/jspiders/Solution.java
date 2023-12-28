package com.jspiders;

import java.util.Scanner;

import com.customException.InvalidChoiceException;

public class Solution {
	
	public static void main(String[] args) {

		Scanner sc =new Scanner(System.in);
		StudentManagementSystem sms=new StudentManagementSystemImpl();
		System.out.println("Welcome to Student DATABASE ManagementSystem");
		System.out.println("----------------------------");
		while(true) {
			
			System.out.println("1:AddStudent\n2:DisplayStudent");
			System.out.println("3:DisplayAllStudent\n4:RemoveStudent");
			System.out.println("5:RemoveAllStudent\n6:UpdateStudent");
			System.out.println("7:CountStudent\n8:SortStudents\n9:Exit");
			System.out.println("Enter Choice");
			int choice=sc.nextInt();

			switch(choice) {
			case 1:
				sms.addStudent();
				break;
			case 2:
				sms.displayStudent();
				break;
			case 3:
				sms.displayAllStudent();
				break;
			case 4:
				sms.removeStudent();
				break;
			case 5:
				sms.removeAllStudent();
				break;
			case 6:
				sms.updateStudent();
				break;
			case 7:
				sms.countStudent();
				break;
			case 8:
				sms.sortStudents();
				break;
			case 9:
				System.out.println("Thank You !!!");
				System.exit(0);
			default:
				try {
					throw new InvalidChoiceException("Invalid Choice\n Kindly choice from above");
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
			}
		System.out.println("***********************");	

		}
	}

}
