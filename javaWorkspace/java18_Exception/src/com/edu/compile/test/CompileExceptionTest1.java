package com.edu.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;

class FileReading {
	public void readFile(String fileName) {
		// 파일안의 내용을 읽어들이는 로직을 작성..
		
		try {
			FileReader fr = new FileReader(fileName);
			System.out.println("1. FileReader Creating...");		// 터져도 출력 됨(이미 위에서 해결했기 때문에)
		} catch(FileNotFoundException e) {
			/*
			 * 둘다 같은 기능임
			 * 1. e.printStackTrace();  => 에러 경로를 추적 해주지만, 보안상에 문제가 있어 안씀 
			 * 2. System.out.println(e.getMessage());	// 너무 짧게 알려줌. 용도가 따로 있음
			*/
			System.out.println("파일을 찾을 수 없습니다.." + e);
		}
		System.out.println("2. file...end...");
		
	}
}

public class CompileExceptionTest1 {
	public static void main(String[] args) {
		FileReading fr = new FileReading();
		String fileName = "C:\\bnk_jsy\\util\\eclipse-jee-photon-R-win32-x86_64.zip";
		fr.readFile(fileName);
		System.out.println("3. 파일을 잘 읽어들였습니다..");

	}

}
