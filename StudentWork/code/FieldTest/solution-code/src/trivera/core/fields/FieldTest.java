package trivera.core.fields;

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

public class FieldTest {

    // The four uninitialized private instance fields
    private String string;

    private int x;

    private double y;

    private boolean yn;

    public FieldTest() {
        super();

        // Part 1 - Create uninitialized variable x, do the rest of the code,
        // attempt to compile
        // Part 2 - Rest of code won't compile while x in uninitialized, so
        // after compile fails, initialize x

        int x = 5;

        // Print out each of the four instance fields

        System.out.println("string is: " + this.string);
        System.out.println("x is: " + this.x);
        System.out.println("y is: " + this.y);
        System.out.println("yn is: " + this.yn);
        // Print out the local variable x
        System.out.println("local x is: " + x);

        /*
         * Remember that local variable x will hide instance field x. How do we
         * specify that we want the instance field and not the variable ?
         */
    }

    public static void main(String[] args) {
        // LAB HINT: Create an instance of this class using the basic constructor
        new FieldTest();

        // verify the version of Java that is running
        System.out.println(System.getProperty("java.version"));

    }
}
