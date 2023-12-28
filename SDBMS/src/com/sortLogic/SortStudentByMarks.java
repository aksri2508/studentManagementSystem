package com.sortLogic;

import java.util.Comparator;

import com.jspiders.Student;

public class SortStudentByMarks implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		Double s=o1.getMarks();
		Double s1=o2.getMarks();		
		return s.compareTo(s1);
	}

}
