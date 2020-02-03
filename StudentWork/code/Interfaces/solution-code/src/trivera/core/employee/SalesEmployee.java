package trivera.core.employee;

/**
 * <p>
 * This component and its source code representation are copyright protected and
 * proprietary to Trivera Technologies, LLC, Worldwide D/B/A Trivera
 * Technologies
 *
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of Trivera
 * Technologies, LLC
 *
 * Copyright (c) 2020 Trivera Technologies, LLC. http://www.triveratech.com
 * </p>
 * 
 * @author Trivera Technologies Tech Team.
 */

public class SalesEmployee extends Employee {
	// Instance fields
	private double salesAmount;

	private double commissionRate;

	// Define get- and set- methods for salesAmount and commissionRate
	public double getCommissionRate() {
		return commissionRate;
	}

	public double getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(double salesAmount) {
		this.salesAmount = salesAmount;
	}

	// throws InvalidCommissionRateException is for exercise on Exceptions
	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}

	// Define a constructor which accepts a name and a employee number, and use
	// the constructor of Employee
	public SalesEmployee(String name, int empID) {
		super(name, empID);
	}

	// Override the calcSalary method and calculate the salary based on sales
	public double calcSalary() {
		return this.salesAmount * this.commissionRate;
	}

}