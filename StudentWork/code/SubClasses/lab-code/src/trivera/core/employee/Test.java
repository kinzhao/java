package trivera.core.employee;
import java.util.*;
import java.text.*;
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

public class Test {

    public static void main(String[] args) {
        Person pers = null;
        Employee emp = null;

        // LAB HINT: Instantiate a person and an employee,
        //           using the two variables supplied
        pers = new Person("John");
        emp = new Employee("John");

        Employeee[] emps = new Employee[2];

        // LAB HINT: Print the instance variables by way of their toString() method
//        System.out.println(pers.toString());
//        System.out.println(pers.getName());
//        System.out.println(emp.toString());
//        System.out.println(emp.getName());
//        System.out.println(pers.equals(emp));

//        NumberFormat fmt = NumberFormat.getInstance();
//        System.out.println(fmt.format(10000000));


        String[] strings;
        strings = new String[4];
        strings[0] = "Hello";
        strings[1] = "Hello";
        strings[2] = "Blah";
        strings[3] = "Hello";

        String[] literals = {"Now", "Is", "The", "Time"};
        for(String str : strings) {
            System.out.println(str);
        }


    }

}