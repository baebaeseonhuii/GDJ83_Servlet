package com.seonhui.home.student;

import java.util.List;

public class StudentService {
	private StudentDAO studentDAO;

	public StudentService() {
		studentDAO = new StudentDAO();
	}

	public StudentDTO makeStudent() {
		StudentDTO student = new StudentDTO();
		student.setNum(1);
		student.setName("seonhui");
		student.setAvg(56.32);

		return student;
	}

	public List<StudentDTO> getStudents() throws Exception {
		List<StudentDTO> ar = studentDAO.getStudents();
		return ar;
	}

	public StudentDTO getDetail(StudentDTO studentDTO) {
		try {
			studentDTO = studentDAO.getDetail(studentDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			studentDTO = null;
		}
		return studentDTO;
	}
}
