package web.client;

import java.util.Scanner;

import web.controller.Controller;
import web.factory.ControllerFactory;

public class ClientTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	// 화면에 폼으로 값을 입력한다고...생각하고
		System.out.println(">>> command 값 입력");
		
		String command = sc.next();
		
		ControllerFactory factory = ControllerFactory.getInstance();
		
		Controller controller = factory.createController(command);
		controller.handle();
	}

}
