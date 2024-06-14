package com.seonhui.home.student;

import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import com.seonhui.home.Action;

public class StudentController {

	private StudentService studentService;

	public StudentController() {
		this.studentService = new StudentService();
	}

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	public Action start(HttpServletRequest request) throws Exception {
		// /student/??? -> uri를 request에서 꺼내와서 if
		String uri = request.getRequestURI();

		// /student/list라는 주소가 들어오면 -> 학생 정보 전체 출력
		StringTokenizer st = new StringTokenizer(uri, "/");
		String s = st.nextToken();
		String afterStudent = st.nextToken();
		// /student/add라는 주소가 들어오면 -> 학생 한명 정보 추가
		// /student/delete -> 학생 한명 삭제
		// /student/detail -> 학생 한명 검색
		Action action = new Action();
		action.setFlag(true);
		String method = request.getMethod();

		if (afterStudent.equals("list")) {
			List<StudentDTO> studentList = studentService.getStudents();
			request.setAttribute("studentList", studentList);
			action.setPath("/WEB-INF/views/student/list.jsp");
		} else if (afterStudent.equals("add")) {
			if (method.toUpperCase().equals("POST")) {
				System.out.println("학생 등록 데이터를 꺼내야 함");
				StudentDTO student = new StudentDTO();
				String name = request.getParameter("name");
				String num = request.getParameter("num");
				String avg = request.getParameter("avg");
				student.setName(name);
				student.setNum(Integer.parseInt(num));
				student.setAvg(Double.parseDouble(avg));
				System.out.println(student.getNum());
				System.out.println(student.getName());
				System.out.println(student.getAvg());
				System.out.println(request.getParameter("ch"));
				System.out.println(request.getParameter("mobile"));
				String[] ch2 = request.getParameterValues("ch2");

				for (String a : ch2) {
					System.out.println(a);
				}
				action.setFlag(false);
				action.setPath("./list");
			} else {
				action.setPath("/WEB-INF/views/student/add.jsp");
			}

		} else if (afterStudent.equals("delete")) {
			// action.setPath("/WEB-INF/views/student/delete.jsp");
		} else if (afterStudent.equals("detail")) {
			String num = request.getParameter("num");
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setNum(Integer.parseInt(num));
			studentDTO = studentService.getDetail(studentDTO);
			if (studentDTO != null) {
				request.setAttribute("studentDetail", studentDTO);
				action.setPath("/WEB-INF/views/student/detail.jsp");
			} else {
				request.setAttribute("message", "No data");
				action.setPath("/WEB-INF/views/commons/message.jsp");
			}
//			request.setAttribute("name", name);
//			request.setAttribute("avg", avg); // 이 지역변수들이 request에 저장돼서 jsp까지 살아있음

		} else {

		}
		return action;

	}
}
