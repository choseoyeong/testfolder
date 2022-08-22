package com.edu.broker.vo;

import java.sql.Date;

public class Trade {
	private int tradeId;
	private String ssn;
	private int stockId;
	private int quantity;
	private Date tradeDate;
	
	public Trade(int tradeId, String ssn, int stockId, int quantity, Date tradeDate) {
		super();
		this.tradeId = tradeId;
		this.ssn = ssn;
		this.stockId = stockId;
		this.quantity = quantity;
		this.tradeDate = tradeDate;
	}

	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", ssn=" + ssn + ", stockId=" + stockId + ", quantity=" + quantity
				+ ", tradeDate=" + tradeDate + "]";
	}
	
}
