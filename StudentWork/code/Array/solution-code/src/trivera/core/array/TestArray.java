package trivera.core.array;

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

public class TestArray {

    public static void main(java.lang.String[] args) {
        // verify the version of Java that is running
        System.out.println(System.getProperty("java.version"));

        // Declare the String array.
        String[] myArray;

        // Allocate five entries to the array.
        myArray = new String[5];

        // Initialize each entry to a String
        myArray[0] = new String("Element 0");
        myArray[1] = new String("Element 1");
        myArray[2] = new String("Element 2");
        myArray[3] = new String("Element 3");
        myArray[4] = new String("Element 4");
        // Use a for loop to print the elements of the array. Assume that you do
        // not
        // know the size of the array.

        for (int a = 0; a < myArray.length; a++)
            System.out.println(myArray[a]);
    }
}
