package com.seonhui.home;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seonhui.home.student.StudentController;
import com.seonhui.home.weather.WeatherController;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();// 부모 생성자 호출
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("실행됨");

		String uri = request.getRequestURI();
		String method = request.getMethod();

		if (!uri.equals("/favicon.ico")) {
			// 1. substring
//			String path = uri.substring(1, uri.lastIndexOf("/"));
//			System.out.println(path);
			// 2. split()
			String[] p = uri.split("/");
//			for (String s : p) {
//				System.out.println(s);
//			}

//			StringTokenizer st = new StringTokenizer(uri, "/");
//			String student = st.nextToken();
//			System.out.println(uri);
//			System.out.println(method);

			String path = "";
			Action action = new Action();

			if (uri.equals("/")) {
				// index.jsp가고싶다
				action.setFlag(true);
				action.setPath("/WEB-INF/views/index.jsp");

			} else if (p[1].equals("student")) {
				// student/list.jsp가고싶다

				StudentController sc = new StudentController();
				action = sc.start(request);

			} else if (p[1].equals("weather")) {
				// weather/list.jsp가고싶다

				WeatherController wc = new WeatherController();
				action = wc.start(request);

			}

			if (action.isFlag()) {
				RequestDispatcher view = request.getRequestDispatcher(action.getPath());
				view.forward(request, response);// 실행은 여기서 됨 jsp를 찾으러 간다는 뜻
			} else {
				response.sendRedirect(action.getPath());
			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response); // 다시 doGet메소드를 실행해라
	}

}
