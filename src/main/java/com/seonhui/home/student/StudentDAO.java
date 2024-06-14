package com.seonhui.home.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StudentDAO {

	public List<StudentDTO> getStudents() throws Exception {
		File file = new File("C:\\study\\student.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		List<StudentDTO> ar = new ArrayList<StudentDTO>();
		while (true) {
			String s = br.readLine();
			if (s == null) {
				break;
			}
			StringTokenizer st = new StringTokenizer(s, "-");
			StudentDTO studentDTO = new StudentDTO();

			while (st.hasMoreTokens()) {
				studentDTO.setNum(Integer.parseInt(st.nextToken()));
				studentDTO.setName(st.nextToken().trim());
				studentDTO.setKor(Integer.parseInt(st.nextToken().trim()));
				studentDTO.setEng(Integer.parseInt(st.nextToken().trim()));
				studentDTO.setMath(Integer.parseInt(st.nextToken().trim()));
				studentDTO.setTotal(Integer.parseInt(st.nextToken().trim()));
				studentDTO.setAvg(Double.parseDouble(st.nextToken().trim()));
			}
			ar.add(studentDTO);
		}
		br.close();
		fr.close();
		return ar;
	}

	public StudentDTO getDetail(StudentDTO studentDTO) throws Exception {
		List<StudentDTO> ar = this.getStudents();
		StudentDTO result = null;
		for (StudentDTO s : ar) {
			if (s.getNum() == studentDTO.getNum()) {
				result = s;
				break;
			}
		}

		return result;
	}
}
