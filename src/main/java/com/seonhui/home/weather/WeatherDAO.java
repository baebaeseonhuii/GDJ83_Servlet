package com.seonhui.home.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;

public class WeatherDAO {
	// DTO: Data Transfer Object
	// DAO: Data Access Object

	// getWeathers
	// 파일에 날씨 정보들을 읽어와서 parsing 한 후에 DTO에 담아서 리턴 ArrayList에 담아서
	// 파일에서 전체를 꺼내오는 메서드
	public List<WeatherDTO> getWeathers() throws Exception {
		File file = new File("C:\\study\\weather.txt");
		FileReader fr = new FileReader(file); // 읽는 객체
		BufferedReader br = new BufferedReader(fr); // 연결해주는 애

		ArrayList<WeatherDTO> ar = new ArrayList<WeatherDTO>();
		while (true) {
			String s = br.readLine();// 한줄씩 읽는 애

			if (s == null) {
				break;
			}
			s = s.replace(",", "-");
			StringTokenizer st = new StringTokenizer(s, "-");
			WeatherDTO dto = new WeatherDTO();

			while (st.hasMoreTokens()) {
				dto.setNum(Long.parseLong(st.nextToken().trim()));
				dto.setCity(st.nextToken().trim());
				dto.setGion(Double.parseDouble(st.nextToken().trim()));
				dto.setStatus(st.nextToken().trim());
				dto.setHumidity(Integer.parseInt(st.nextToken().trim()));
			}
			ar.add(dto);
		}
		br.close();
		fr.close();
		return ar;
	}

	public WeatherDTO getDetail(WeatherDTO weatherDTO) throws Exception {
		List<WeatherDTO> ar = this.getWeathers();
		WeatherDTO result = null;
		for (WeatherDTO w : ar) {
			if (w.getNum() == weatherDTO.getNum()) {
				result = w;
				break;
			}
		}

		return result;
	}

	public void addWeather(WeatherDTO weatherDTO) throws Exception {
		List<WeatherDTO> ar = this.getWeathers();
		Calendar ca = Calendar.getInstance();

//		// 도시명-기온-상태-습도
//		StringBuffer sb = new StringBuffer();
//		sb.append(ar.size() + 1);
//		sb.append("-");
//		sb.append(weatherDTO.getCity());
//		sb.append("-");
//		sb.append(weatherDTO.getGion());
//		sb.append("-");
//		sb.append(weatherDTO.getStatus());
//		sb.append("-");
//		sb.append(weatherDTO.getHumidity());

		File file = new File("C:\\study\\weather.txt");
		FileWriter fw = null;

		try {
			fw = new FileWriter(file, true);
			String s = ca.getTimeInMillis() + "-" + weatherDTO.getCity() + "-" + weatherDTO.getGion() + "-"
					+ weatherDTO.getStatus() + "-" + weatherDTO.getHumidity();
			fw.write(s + "\n");
			System.out.println(s);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fw.close();
		}
	}

	public void deleteWeather(WeatherDTO weatherDTO) throws Exception {
		// 리스트로 받아와서 입력된 정보랑 일치하는 애를 찾아서 그걸 지우기?
		// 파일 전체를 다시 쓰기, 새로운 데이터로 덮어씌우기
		// 기존 weatherDTOs 리스트에서 해당 도시명이면 건너뛰기
		List<WeatherDTO> ar = this.getWeathers();

		File file = new File("C:\\study\\weather.txt");
		FileWriter fw = new FileWriter(file, false);// 덮어씌워야해서 false

		int flag = 0;
		for (WeatherDTO dto : ar) {
			if (dto.getNum() == weatherDTO.getNum()) {
				flag++;
				continue;
			}
			String s = dto.getNum() - flag + "-" + dto.getCity() + "-" + dto.getGion() + "-" + dto.getStatus() + "-"
					+ dto.getHumidity();
			fw.write(s + "\n");
		}

		fw.close();

//		for (int i = 0; i < ar.size(); i++) {
//			if (ar.get(i).getNum() == weatherDTO.getNum()) {
//
//				continue;
//			}
//			// 파일에 덮어씌워 추가
//			String s = (ar.get(i).getNum() - 1) + "-" + ar.get(i).getCity() + "-" + ar.get(i).getGion() + "-"
//					+ ar.get(i).getStatus() + "-" + ar.get(i).getHumidity();
//			fw.write(s + "\n");
//			System.out.println(s);
//
//		}
//		fw.close();
	}

	public void updateWeather(WeatherDTO weatherDTO) throws Exception {
		List<WeatherDTO> ar = this.getWeathers();
		File file = new File("C:\\study\\weather.txt");
		FileWriter fw = new FileWriter(file, false);
		FileReader fr = new FileReader(file); // 읽는 객체
		BufferedReader br = new BufferedReader(fr); // 연결해주는 애

		// add(index, Object) -> 해당 인덱스 번호를 오브젝트로 바꿔라
		for (int i = 0; i < ar.size(); i++) {
			if (weatherDTO.getNum() == ar.get(i).getNum()) {
				// 일치하면 데이터를 하나하나 다 바꾸기
				ar.get(i).setCity(weatherDTO.getCity());
				// i번째에서 아예 교체
				ar.set(i, weatherDTO);
				break;
			}

		}
		for (WeatherDTO dto : ar) {
			String s = dto.getNum() + "-" + dto.getCity() + "-" + dto.getGion() + "-" + dto.getStatus() + "-"
					+ dto.getHumidity();
			fw.write(s + "\n");
		}

		fw.close();

	}

}
