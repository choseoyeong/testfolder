package spring.service.hello;
/*
 * POJO, Bean Ŭ���� �ۼ� ��Ģ
 * 1. package
 * 2. �⺻������
 * 3. private field
 * 4. public setter/getter
 * 5. �޼ҵ� 
 */
public class Greet {
	private String message;
	
	public Greet() {}

	public Greet(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	// message�� �ܼ�â���� ����ϴ� ���
	public void sayMessage() {
		System.out.println("\n" + getClass().getName() + " ==> " + message);
	}
}