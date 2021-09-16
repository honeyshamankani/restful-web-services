package com.in28minutes.rest.webservices.restfulwebservices.requestchange;

import java.util.List;

import javax.persistence.Entity;

public class Coins {
	
	private int oneCount = 100;
	private int fiveCount = 100;
	private int tenCount = 100;
	private int twentyFiveCount = 100;
	
	@Override
	public String toString() {
		return "Coins [oneCount=" + oneCount + ", fiveCount=" + fiveCount + ", tenCount=" + tenCount
				+ ", twentyFiveCount=" + twentyFiveCount + "]";
	}
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
	public int getTwentyFiveCount() {
		return twentyFiveCount;
	}
	public void setTwentyFiveCount(int twentyFiveCount) {
		this.twentyFiveCount = twentyFiveCount;
	}
	
	
}
