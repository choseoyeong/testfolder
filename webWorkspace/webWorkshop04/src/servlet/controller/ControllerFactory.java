package servlet.controller;

public class ControllerFactory {
	private static ControllerFactory factory = new ControllerFactory();
	private ControllerFactory() {
		System.out.println("ControllerFactory 생성..");
	}
	public static ControllerFactory getInstance() { return factory; }
	
	
	public Controller createController(String command) {
		System.out.println("IN ControllerFactory");
		Controller controller = null;
		
		if(command.equals("login")) {
			controller = new LoginController();
		} else if(command.equals("register")) {
			controller = new RegisterController();
		} else if(command.equals("allBook")) {
			controller = new AllBookController();
		}
		
		return controller;
	}
	
	
}
