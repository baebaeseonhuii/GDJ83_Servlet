package com.seonhui.home.weather;

import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import com.seonhui.home.Action;

public class WeatherController {

	private WeatherService weatherService;

	public WeatherController() {
		this.weatherService = new WeatherService();

		// 어차피 생성자는 한번 호출되니까 생성자에서 객체 만듦
	}

	public WeatherController(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	public Action start(HttpServletRequest request) throws Exception {
		// /weather/list
		String uri = request.getRequestURI();
		StringTokenizer st = new StringTokenizer(uri, "/");
		String weather = st.nextToken();
		String afterWeather = st.nextToken();

		Action action = new Action();
		action.setFlag(true);
		String method = request.getMethod().toUpperCase();

		if (afterWeather.equals("list")) {
			List<WeatherDTO> weatherList = weatherService.getWeathers();
			request.setAttribute("weatherList", weatherList);
			// jsp의 경로명
			action.setPath("/WEB-INF/views/weather/list.jsp");
		} else if (afterWeather.equals("add")) {
			if (method.equals("POST")) {
				WeatherDTO weatherDTO = new WeatherDTO();
				String city = request.getParameter("city");
				double gion = Double.parseDouble(request.getParameter("gion"));
				String status = request.getParameter("status");
				int humidity = Integer.parseInt(request.getParameter("humidity"));
				weatherDTO.setCity(city);
				weatherDTO.setGion(gion);
				weatherDTO.setStatus(status);
				weatherDTO.setHumidity(humidity);
				weatherService.addWeather(weatherDTO);
				// 밑의 두 줄이 없으면 리스트로 가도 아무것도 안보임->jsp에 보내준게 없어서
				List<WeatherDTO> weatherList = weatherService.getWeathers();
				request.setAttribute("weatherList", weatherList);
				// FrontController에서 response.sendRedirect(action.getPath())여기로 들어가야하니까
				// else가 돼야하니까 flag를 false로
				action.setFlag(false);
				// redirect로 jsp안 거치고 현재 폴더의 list로 감
				action.setPath("./list");

			} else {
				action.setPath("/WEB-INF/views/weather/add.jsp");
			}

		} else if (afterWeather.equals("detail")) {
			String num = request.getParameter("num");
			WeatherDTO weatherDTO = new WeatherDTO();
			weatherDTO.setNum(Long.parseLong(num));
			weatherDTO = weatherService.getDetail(weatherDTO);

			if (weatherDTO != null) {
				request.setAttribute("weatherDetail", weatherDTO);
				action.setPath("/WEB-INF/views/weather/detail.jsp");

			} else {
				request.setAttribute("message", "정보가 없습니다.");
				action.setPath("/WEB-INF/views/commons/message.jsp");
			}

		} else if (afterWeather.equals("delete")) {
			action.setPath("/WEB-INF/views/weather/delete.jsp");
		} else {

		}
		return action;
	}
}
