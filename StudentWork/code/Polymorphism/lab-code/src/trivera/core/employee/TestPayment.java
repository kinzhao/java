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


public class TestPayment {

    public static void PayEveryone(Payable... emps) {
        double total = 0;
        for(Payable emp: emps) {
            total += emp.calcSalary();
        }
        System.out.println("Paid a total of $" + total);
    }

    public static void main(String[] args) {
        Employee el = new Employee("Betty", 101);
        Employee e2 = new Employee("Willma", 102);
        HourlyEmployee h1 = new HourlyEmployee("BamBam", 103);
        h1.setHourRate(10);
        h1.setHoursWorked(40);

        SalesEmployee s1 = new SalesEmployee("Who Me", 104);
        s1.setCommissionRate(10);
        s1.setSalesAmount(4000);
        PayEveryone(el, e2, h1, s1, new Vendor());


        SalesEmployee jennifer = null;
        HourlyEmployee john = null;

        Employee[] staff = new Employee[2];

        // Instantiate jennifer and john
        //jennifer = new ????
        //john = new ????

        // LAB HINT: Set values for salesAmount and commission for jennifer


        // LAB HINT: Set staff[0] to jennifer


        // LAB HINT: Set values for hourRate and hoursWorked for john


        // LAB HINT: Set staff[1] to john


        // LAB HINT: Loop through the list of Employees and print out salary.


    }

}