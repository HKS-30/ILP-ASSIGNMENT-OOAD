package com.ilp.entity;

import java.util.ArrayList;

public class SavingsAccount extends Product {
	private double minBalance;

	public SavingsAccount(String productCode, String productName, ArrayList<Service> serviceList, double minBalance) {
		super(productCode, productName, serviceList);
		this.minBalance = minBalance;
	}

	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}
	
}
