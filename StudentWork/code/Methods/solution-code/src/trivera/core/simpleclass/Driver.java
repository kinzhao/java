package trivera.core.simpleclass;

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

public class Driver {

    public static void main(java.lang.String[] args) {

        // Creates an instance of the Employee class and save the reference in a
        // variable
        Employee employee = new Employee();
        
        employee.name = "Jim";
        employee.salary = 30000;
        
        System.out.println(employee.name + " makes $" + employee.salary);

        // Construct an instance, passing a name and a salary
        Employee simple = new Employee("Mary", 5000000);

        // Use the set methods to change the name and salary
        simple.setName("Mary Duncan");
        simple.setSalary(6000000);

        // Use the get methods to get the name and salary, and save in variables
        String name = simple.getName();
        int salary = simple.getSalary();

        // Print out the name and salary
        System.out.println("Name: " + name + " - Salary: " + salary);

        // verify the version of Java that is running
        System.out.println(System.getProperty("java.version"));
    }
}
