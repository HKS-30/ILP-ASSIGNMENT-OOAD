package com.ilp.entity;

import java.util.ArrayList;

public class LoanAccount extends Product {
	private double chequedepositCharge = .03;
	


	public double getChequedepositCharge() {
		return chequedepositCharge;
	}

	public void setChequedepositCharge(double chequedepositCharge) {
		this.chequedepositCharge = chequedepositCharge;
	}

	public LoanAccount(String productCode, String productName, ArrayList<Service> serviceList,
			double chequedepositCharge) {
		super(productCode, productName, serviceList);
		this.chequedepositCharge = chequedepositCharge;
	}
	
}
