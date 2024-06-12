package com.seonhui.home.weather;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WeatherService {

	private StringBuffer sb;

	// 1. 각 url에 맞는 jsp로 연결
	// 2. root/weather/list 주소 들어오면 service의 getWeathers 실행
	// 3. DTO들을 List에 담아서 jsp에서 테이블에 담기
	public WeatherService() {
		this.sb = new StringBuffer();
		this.sb.append("서울  , 29.3 - 맑음 - 60");
		this.sb.append("-부산  , 33.6 - 흐림 - 90");
		this.sb.append("-제주  , 26.5 - 눈 - 30");
		this.sb.append("-Los Angeles  , 20.7 - 맑음 - 35");
		this.sb.append("-대전  , 8.9 - 태풍 - 70");
		this.sb.append("-울산  , 22.4 - 비 - 80");
	}

	public List<WeatherDTO> getWeathers() {
		String info = sb.toString();
		info = info.replace(",", "-");
		StringTokenizer st = new StringTokenizer(info, "-");

		ArrayList<WeatherDTO> arr = new ArrayList<WeatherDTO>();

		while (st.hasMoreTokens()) {
			WeatherDTO dto = new WeatherDTO();
			dto.setCity(st.nextToken().trim());
			dto.setGion(Double.parseDouble(st.nextToken().trim()));
			dto.setStatus(st.nextToken().trim());
			dto.setHumidity(Integer.parseInt(st.nextToken().trim()));
			arr.add(dto);
		}
		return arr;
	}
}
