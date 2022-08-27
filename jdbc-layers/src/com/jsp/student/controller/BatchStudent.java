package com.jsp.student.controller;

import java.util.ArrayList;

import com.jsp.student.dao.StudentCrud;
import com.jsp.student.dto.Student;

public class BatchStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentCrud studentCrud=new StudentCrud();
		Student s1=new Student();
		s1.setId(1);
		s1.setName("asd");
		s1.setEmail("asd@mail.com");
		
		Student s2=new Student();
		s2.setId(2);
		s2.setName("ram");
		s2.setEmail("ram@mail.com");
		
		Student s3=new Student();
		s3.setId(3);
		s3.setName("sham");
		s3.setEmail("sham@mail.com");
		
		ArrayList<Student>arrayList= new ArrayList<>();
		arrayList.add(s1);
		arrayList.add(s2);
		arrayList.add(s3);
		
		studentCrud.batchExecution(arrayList);
		
	}

}
