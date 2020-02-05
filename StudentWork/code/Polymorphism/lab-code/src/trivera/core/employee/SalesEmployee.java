package trivera.core.employee;

/**
 * <p>
 * This component and its source code representation are copyright protected
 * and proprietary to Trivera Technologies, LLC, Worldwide D/B/A Trivera Technologies
 *
 * This component and source code may be used for instructional and
 * evaluation purposes only. No part of this component or its source code
 * may be sold, transferred, or publicly posted, nor may it be used in a
 * commercial or production environment, without the express written consent
 * of Trivera Technologies, LLC
 *
 * Copyright (c) 2020 Trivera Technologies, LLC.
 * http://www.triveratech.com   
 * </p>
 * @author Trivera Technologies Tech Team.
 */


public class SalesEmployee extends Employee{
    // Instance fields
    private double salesAmount;

    private double commissionRate;

    // LAB HINT: Define get- and set- methods for
    //           salesAmount and commissionRate

    public double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(double salesAmount) {
        this.salesAmount = salesAmount;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }
    // LAB HINT: Define a constructor which accepts a name and a
    //           employee number, and uses the constructor of Employee

    SalesEmployee(String name, int empID) {
        super(name, empID);
    }
    // LAB HINT: Override the calcSalary method and
    //           calculate the salary based on sales


    @Override
    public double calcSalary() {
        return getSalesAmount()*(getCommissionRate()/100);
    }
}