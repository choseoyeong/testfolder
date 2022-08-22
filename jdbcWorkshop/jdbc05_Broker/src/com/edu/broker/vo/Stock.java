package com.edu.broker.vo;

public class Stock {
	private int stockId;
	private String stockName;
	private double price;
	
	public Stock(int stockId, String stockName, double price) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.price = price;
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stockName=" + stockName + ", price=" + price + "]";
	}
	
}
