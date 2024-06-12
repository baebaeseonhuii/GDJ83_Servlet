package com.seonhui.home.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentService {

	public Student makeStudent() {
		Student student = new Student();
		student.setNum(1);
		student.setName("seonhui");
		student.setAvg(56.32);

		return student;
	}

	public List<Student> getStudents() {
		ArrayList<Student> ar = new ArrayList<Student>();
		Random random = new Random();

		for (int i = 0; i < 5; i++) {
			Student student = new Student();
			student.setNum(i + 1);
			student.setName("name" + (i + 1));
			student.setAvg(random.nextInt(100) + random.nextDouble());
			ar.add(student);

		}
		return ar;

	}
}
