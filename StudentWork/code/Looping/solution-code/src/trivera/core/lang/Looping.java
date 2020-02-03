package trivera.core.lang;

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


public class Looping {

    public static void main(java.lang.String[] args) {
        // Write a for loop in THIS main.
        // Loop from 0 to less than 10.

        for (int a = 0; a < 10; a++) {
            // Within the loop, print out the value of your counter.
            System.out.println("The value of (a) is: " + a);

        }
        // verify the version of Java that is running
        System.out.println(System.getProperty("java.version"));
    }
}
