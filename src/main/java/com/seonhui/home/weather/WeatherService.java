package com.seonhui.home.weather;

import java.util.List;

public class WeatherService {
	private WeatherDAO weatherDAO;

	// 1. 각 url에 맞는 jsp로 연결
	// 2. root/weather/list 주소 들어오면 service의 getWeathers 실행
	// 3. DTO들을 List에 담아서 jsp에서 테이블에 담기
	public WeatherService() {
		weatherDAO = new WeatherDAO();
	}

	public List<WeatherDTO> getWeathers() throws Exception {
		List<WeatherDTO> ar = weatherDAO.getWeathers();
		return ar;
	}

	// detail가져오기
	public WeatherDTO getDetail(WeatherDTO weatherDTO) {

		try {
			weatherDTO = weatherDAO.getDetail(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			weatherDTO = null;// 이미 만들어진 매개변수 weatherDTO는 null이 아니라서
		}
		return weatherDTO;
	}

	public void addWeather(WeatherDTO weatherDTO) {
		try {
			weatherDAO.addWeather(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
