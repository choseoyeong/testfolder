package com.edu.collection.test;

import java.util.Enumeration;
import java.util.Properties;

/*
 * VM관련 환경변수들을 다 출력하는 로직을 작성.
 * 
 * 
 */
public class PropertiesTest1 {
	public static void main(String[] args) {
		Properties p = System.getProperties();
		
		Enumeration e = p.propertyNames();
		while(e.hasMoreElements()) {
			String name = (String)e.nextElement();
			String value = p.getProperty(name);
			System.out.println(name + "===================" + value);
		}
	}

}
