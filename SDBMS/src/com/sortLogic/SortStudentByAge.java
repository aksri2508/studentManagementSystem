package com.sortLogic;

import java.util.Comparator;

import com.jspiders.Student;

public class SortStudentByAge implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getAge()-o2.getAge();
	}

}
