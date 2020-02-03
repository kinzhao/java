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

    public static void main(String[] args) {
        SalesEmployee jennifer = null;
        HourlyEmployee john = null;

        Employee[] staff = new Employee[2];

        // Instantiate jennifer and john
        jennifer = new SalesEmployee("Jennifer Wirth", 12);
        john = new HourlyEmployee("John Wirth", 35);

        // Set values for salesAmount and commission for jennifer
        jennifer.setSalesAmount(200000);
        jennifer.setCommissionRate(0.04);

    // Set staff[0] to jennifer
    staff[0] = jennifer;

        // Set values for hourRate and hoursWorked for john
        john.setHourRate(16);
        john.setHoursWorked(160);

        // Set staff[1] to john
        staff[1] = john;

        // Loop through the list of Employees and print out the salary.
        for (int i = 0; i < staff.length; i++) {
            System.out.println("Employee: " + staff[i] + ", Salary: "
                    + staff[i].calcSalary());

        }
        // verify the version of Java that is running
        System.out.println(System.getProperty("java.version"));

    }

}