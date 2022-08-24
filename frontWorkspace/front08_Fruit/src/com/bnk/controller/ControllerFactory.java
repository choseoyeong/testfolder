package com.bnk.controller;

public class ControllerFactory {
	private static ControllerFactory factory = new ControllerFactory();
	private ControllerFactory() { 
		System.out.println("ControllerFactory 싱글톤..");
	};
	public static ControllerFactory getInstance() { return factory ; }
	
	// Component를 생성하는 기능...정의
	public Controller createController(String command) {
		Controller controller = null;
		if(command.equals("itemList.do")) {
			controller = new ItemListController();
		}
		else if(command.equals("itemView.do")) {
			controller = new ItemViewController();
		}
		
		return controller;
	}
}
