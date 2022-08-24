package com.edu.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class FileReading3 {
	public void readFile(String fileName) throws IOException {		// FileNotFoundException 포함되어 있음
		// 파일안의 내용을 읽어들이는 로직을 작성..
		FileReader fr = null;
		
		// fr.close()를 꼭 실행하려면 finally를 써야하므로 try문 만들어줌
		try {
			fr = new FileReader(fileName);				
			System.out.println("1. FileReader Creating...");		
		} finally {
			System.out.println("testt");
			fr.close();				
		}
		System.out.println("2. file...end...");
		
	}
}

public class CompileExceptionTest3 {
	public static void main(String[] args) {
		FileReading3 fr = new FileReading3();
		String fileName = "C:\\bnk_jsy\\util\\eclipse-jee-photon-R-win32-x86_64.jpg";
		try {
			fr.readFile(fileName);
		} catch (IOException e) {
			System.out.println("FileNotFound Catch..");
		} catch(Exception e) {
			System.out.println("catchTest!!");
		}
		System.out.println("3. 파일을 잘 읽어들였습니다..");

	}

}
