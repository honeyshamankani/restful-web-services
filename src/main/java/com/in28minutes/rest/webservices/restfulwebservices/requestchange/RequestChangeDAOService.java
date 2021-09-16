package com.in28minutes.rest.webservices.restfulwebservices.requestchange;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class RequestChangeDAOService {
	
	private static List<Bill> bills  = new ArrayList<>();
	private static Coins c = new Coins();
	private static String change = "";
	
	public static List<Integer> addValidBills(List<Integer> validBills) {
		validBills.add(1);
		validBills.add(2);
		validBills.add(5);
		validBills.add(10);
		validBills.add(20);
		validBills.add(50);
		validBills.add(100);
		return validBills;
	}

	public static Bill getChangeOfTwentyFiveScents(double bill, Bill b, double origBill) {
		
		if(c.getTwentyFiveCount() > 0) {
			double count = bill/0.25;
			int val = (int)count;
			double calculatedBill = 0.0;
			if(val <= c.getTwentyFiveCount()) {
				c.setTwentyFiveCount(c.getTwentyFiveCount()-val);
				change = change + val+" coins of 25 cents" +",";
				b = new Bill(origBill, change, c.getOneCount(), c.getFiveCount(), c.getTenCount(), c.getTwentyFiveCount(), 0.0);
			}
			else {
				val = val - c.getTwentyFiveCount();
				change = change + c.getTwentyFiveCount()+" coins of 25 cents" +",";
				c.setTwentyFiveCount(0);
				calculatedBill = val*0.25;
				b = new Bill(origBill, change, c.getOneCount(), c.getFiveCount(), c.getTenCount(), c.getTwentyFiveCount(), calculatedBill);
			}
		}
		else {
			b = new Bill(origBill, change, c.getOneCount(), c.getFiveCount(), c.getTenCount(), c.getTwentyFiveCount(), bill);
		}
		return b;
	}
	
	public static Bill getChangeOfTenScents(double bill, Bill b, double origBill) {
		
		if(c.getTenCount() > 0) {
			double count = bill/0.10;
			int val = (int)count;
			double calculatedBill = 0.0;
			if(val <= c.getTenCount()) {
				c.setTenCount(c.getTenCount()-val);
				change = change + val+" coins of 10 cents" +",";
				b = new Bill(origBill, change, c.getOneCount(), c.getFiveCount(), c.getTenCount(), c.getTwentyFiveCount(), 0.0);
			}
			else {
				val = val - c.getTenCount();
				change = change + c.getTenCount()+" coins of 10 cents" +",";
				c.setTenCount(0);
				calculatedBill = val*0.10;
				b = new Bill(origBill, change, c.getOneCount(), c.getFiveCount(), c.getTenCount(), c.getTwentyFiveCount(), calculatedBill);
			}
		}
		else {
			b = new Bill(origBill, change, c.getOneCount(), c.getFiveCount(), c.getTenCount(), c.getTwentyFiveCount(), origBill);
		}
		
		return b;
	}
	
	public static Bill getChangeOfFiveScents(double bill, Bill b, double origBill) {
		
		if(c.getFiveCount() > 0) {
			double count = bill/0.05;
			int val = (int)count;
			double calculatedBill = 0.0;
			if(val <= c.getFiveCount()) {
				c.setFiveCount(c.getFiveCount()-val);
				change = change + val+" coins of 5 cents" +",";
				b = new Bill(origBill, change, c.getOneCount(), c.getFiveCount(), c.getTenCount(), c.getTwentyFiveCount(), calculatedBill);
			}
			else {
				val = val - c.getFiveCount();
				change = change + c.getFiveCount()+" coins of 5 cents" +",";
				c.setFiveCount(0);
				calculatedBill = val*0.05;
				b = new Bill(origBill, change, c.getOneCount(), c.getFiveCount(), c.getTenCount(), c.getTwentyFiveCount(), calculatedBill);
			}
		}
		else {
			b = new Bill(origBill, change, c.getOneCount(), c.getFiveCount(), c.getTenCount(), c.getTwentyFiveCount(), origBill);
		}
		return b;
	}
	
	
	public static Bill getChangeOfOneScent(double bill, Bill b, double origBill) {
		if(c.getOneCount() > 0) {
			double count = bill/0.01;
			int val = (int)count;
			double calculatedBill = 0.0;
			if(val <= c.getOneCount()) {
				c.setOneCount(c.getOneCount()-val);
				change = change + val+" coins of 1 cent";
				b = new Bill(origBill, change, c.getOneCount(), c.getFiveCount(), c.getTenCount(), c.getTwentyFiveCount(), 0.0);
			}
			else {
				val = val - c.getOneCount();
				change = change + c.getOneCount() +" coins of 1 cent";
				c.setOneCount(0);
				calculatedBill = val*0.01;
				b = new Bill(origBill, change, c.getOneCount(), c.getFiveCount(), c.getTenCount(), c.getTwentyFiveCount(), calculatedBill);
			}
		}
		else {
			b = new Bill(origBill, change, c.getOneCount(), c.getFiveCount(), c.getTenCount(), c.getTwentyFiveCount(), origBill);
		}
		return b;
	}
	
	public static Bill getLeastChange(int bill) {
		change = "";
		Bill b = new Bill();
		int origBill = bill;
		List<Integer> list = new ArrayList<>();
		list = addValidBills(list);
		if(bill > 0 && list.contains(bill)) {
			b = getChangeOfTwentyFiveScents(bill, b, origBill);
			if(b.getCalculatedBill() > 0.0) {
				b= getChangeOfTenScents(b.getCalculatedBill(), b, origBill);
				if(b.getCalculatedBill() > 0.0) {
					b = getChangeOfFiveScents(b.getCalculatedBill(), b, origBill);
					if(b.getCalculatedBill() > 0.0) {
						b = getChangeOfOneScent(b.getCalculatedBill(), b, origBill);
					}
					if(b.getCalculatedBill()>0.0) {
						throw new InsufficientCoinsException("Insufficient number of coins to make change");
					}
//					else {
//						String change = b.getChange();
//						int len = change.length();
//						if(change.charAt(len-1) ==',') {
//							change = change.substring(0, len-1);
//							b.setChange(change);
//						}
//					}
				}
			}
			return b;
		}
		else {
			if(!list.contains(bill)) {
				throw new InvalidBillException("Please enter a valid Bill {1, 2, 5, 10, 20, 50, 100}");
			}
		}
		return b;
	}
	
	public static Bill getMaxChange(int bill) {
		change = "";
		Bill b = new Bill();
		int origBill = bill;
		List<Integer> list = new ArrayList<>();
		list = addValidBills(list);
		if(bill > 0 && list.contains(bill)) {
			b = getChangeOfOneScent(bill, b, origBill);
			if(b.getCalculatedBill() > 0.0) {
				b= getChangeOfFiveScents(b.getCalculatedBill(), b, origBill);
				if(b.getCalculatedBill() > 0.0) {
					b = getChangeOfTenScents(b.getCalculatedBill(), b, origBill);
					if(b.getCalculatedBill() > 0.0) {
						b = getChangeOfTwentyFiveScents(b.getCalculatedBill(), b, origBill);
					}
					if(b.getCalculatedBill()>0.0) {
						throw new InsufficientCoinsException("Insufficient number of coins to make change");
					}
					
				}
			}
//			String change = b.getChange();
//			int len = change.length();
//			if(change.charAt(len-1) ==',') {
//				change = change.substring(0, len-1);
//				b.setChange(change);
//			}
			return b;
		}
		else {
			if(!list.contains(bill)) {
				throw new InvalidBillException("Please enter a valid Bill {1, 2, 5, 10, 20, 50, 100}");
			}
		}
		return b;
	}
	
	public static ResponseEntity<Object> setCoinCapacity(int oneCentCount, int fiveCentCount, int tenCentCount, int twentyFiveCentCount) {
		if(oneCentCount < 0 || fiveCentCount < 0 || tenCentCount < 0 || twentyFiveCentCount < 0) {
			throw new InvalidCoinCapacityException("Please enter a valid coin capacity >= 0");
		}
		c.setOneCount(oneCentCount);
		c.setFiveCount(fiveCentCount);
		c.setTenCount(tenCentCount);
		c.setTwentyFiveCount(twentyFiveCentCount);
		
		URI location = ServletUriComponentsBuilder.
				fromCurrentRequest()
				.path("/{oneCentCount}/{fiveCentCount}/{tenCentCount}/{twentyFiveCentCount}")
				.buildAndExpand(c.getOneCount(), c.getFiveCount(), c.getTenCount(), c.getTwentyFiveCount())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	public static Coins showCoins() {
		return c;
	}
}
