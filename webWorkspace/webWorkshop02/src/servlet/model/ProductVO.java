package servlet.model;

public class ProductVO {
	private int productNumber;	// product_no
	private String name;		// product_name
	private int price;
	private String detail;
	
	private static final int BASE_PRODUCT_NUMBER = 0; 
	
	
	public ProductVO(int productNumber, String name, int price, String detail) {
		super();
		this.productNumber = productNumber;
		this.name = name;
		this.price = price;
		this.detail = detail;
	}
	
	public ProductVO(String name, int price, String detail) {
		this(BASE_PRODUCT_NUMBER, name, price, detail);
	}
	

	public int getProductNumber() {
		return productNumber;
	}


	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	@Override
	public String toString() {
		return "ProductVO [productNumber=" + productNumber + ", name=" + name + ", price=" + price + ", detail=" + detail + "]";
	}
	
	
}
