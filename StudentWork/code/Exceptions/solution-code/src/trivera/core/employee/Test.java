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

public class Test {

    public static void main(String[] args) {
        Person pers = null;
        Employee emp = null;

        // Instantiate a person and an employee, using the two variables
        // supplied
        pers = new Person("Jennifer");
        emp = new Employee("Bob", 10);

        System.out.println("Person   : " + pers);
        System.out.println("Employee : " + emp);

        Employee me = new Employee();
        me.name = new String("Kimberly");
        me.setEmpID(12345);
        Person p = me;

        //Employee you = new Person();
        //p.empID = 4242;
        Test thisTest = new Test();
        thisTest.someMethod(me);

    }

    void someMethod(Person person) {
        // The following code may or may not cause a ClassCastException
        if (person instanceof Employee){
          Employee emp2 = (Employee) person;
          System.out.println("Employee in method : " + emp2);
        }  else {
           System.out.println("Not an employee");
        }
    }
}