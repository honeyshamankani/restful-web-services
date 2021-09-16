package com.in28minutes.rest.webservices.restfulwebservices.requestchange;

import java.util.ArrayList;
import java.util.List;

public class Bill {
	
	private double bill;
	private String change;
	private int oneCount;
	private int fiveCount;
	private int tenCount;
	
	public Bill() {}
	
	public Bill(int bill) {
		this.bill = bill;
	}
	
	public double getCalculatedBill() {
		return calculatedBill;
	}

	public void setCalculatedBill(double calculatedBill) {
		this.calculatedBill = calculatedBill;
	}

	private int twentFiveCount;
	private double calculatedBill;
	
	private Coins coin;


	public int getOneCount() {
		return oneCount;
	}


	public void setOneCount(int oneCount) {
		this.oneCount = oneCount;
	}


	public int getFiveCount() {
		return fiveCount;
	}


	public void setFiveCount(int fiveCount) {
		this.fiveCount = fiveCount;
	}


	public int getTenCount() {
		return tenCount;
	}


	public void setTenCount(int tenCount) {
		this.tenCount = tenCount;
	}

	public Bill(double bill, String change, int oneCount, int fiveCount, int tenCount, int twentyFiveCount, double calculatedBill) {
		super();
		this.bill = bill;
		this.change = change;
		coin = new Coins();
		coin.setOneCount(oneCount);
		coin.setFiveCount(fiveCount);
		coin.setTenCount(tenCount);
		coin.setTwentyFiveCount(twentyFiveCount);
		this.oneCount = coin.getOneCount();
		this.fiveCount = coin.getFiveCount();
		this.tenCount = coin.getTenCount();
		this.twentFiveCount = coin.getTwentyFiveCount();
		this.calculatedBill = calculatedBill;
	}


	public int getTwentFiveCount() {
		return twentFiveCount;
	}

	@Override
	public String toString() {
		return "Bill [bill=" + bill + ", change=" + change + ", oneCount=" + oneCount + ", fiveCount=" + fiveCount
				+ ", tenCount=" + tenCount + ", twentFiveCount=" + twentFiveCount + "]";
	}

	public void setTwentFiveCount(int twentFiveCount) {
		this.twentFiveCount = twentFiveCount;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public double getBill() {
		return bill;
	}

	public void setBill(int bill) {
		this.bill = bill;
	}
	
	

}
