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

	public Action start(HttpServletRequest request) {
		// /weather/list
		String uri = request.getRequestURI();
		StringTokenizer st = new StringTokenizer(uri, "/");
		String weather = st.nextToken();
		String afterWeather = st.nextToken();

		Action action = new Action();
		action.setFlag(true);

		if (afterWeather.equals("list")) {
			List<WeatherDTO> weatherList = weatherService.getWeathers();
			request.setAttribute("weatherList", weatherList);
			// jsp의 경로명
			action.setPath("/WEB-INF/views/weather/list.jsp");
		} else if (afterWeather.equals("add")) {
			action.setPath("/WEB-INF/views/weather/add.jsp");
		} else if (afterWeather.equals("detail")) {
			action.setPath("/WEB-INF/views/weather/detail.jsp");
		} else if (afterWeather.equals("delete")) {
			action.setPath("/WEB-INF/views/weather/delete.jsp");
		} else {

		}
		return action;
	}
}
