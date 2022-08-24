package servlet.controller;

// 결과페이지와 페이지 이동 방법에 대한 정보를 담고 있는 클래스..
public class ModelAndView {
	private String path;	// 결과페이지 이름
	// boolean의 기본값은 false이고, redirect보다 forward가 더 많이 사용되기 때문에 isRedirect로 선언
	private boolean isRedirect;	// 페이지 이동 방법 false --> forward / true --> redirect
	
	public ModelAndView() { }
	
	// redirect일 때 
	public ModelAndView(String path, boolean isRedirect) {
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}

	// forward일 때 
	public ModelAndView(String path) {
		super();
		this.path = path;
	}

	public String getPath() { return path; }
	public void setPath(String path) { this.path = path; }
	public boolean isRedirect() { return isRedirect; }
	public void setRedirect(boolean isRedirect) { this.isRedirect = isRedirect;	}
}
