package trivera.core.strings;

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

public class FunWithStrings {

    public static void main(java.lang.String[] args) {
        // Create four strings
        String string1 = new String("Hello");
        String string2 = new String("Hello");
        String string3 = new String("How are you?");
        String string4 = string3;

        // Print out each string, along with their lengths
        System.out.println("String-1: " + string1 + " Length: "
                + string1.length());
        System.out.println("String-2: " + string2 + " Length: "
                + string2.length());
        System.out.println("String-3: " + string3 + " Length: "
                + string3.length());
        System.out.println("String-4: " + string4 + " Length: "
                + string4.length());

        // If string1 equals string2, print saying so
        if (string1.equals(string2))
            System.out.println("String-1 and String-2 are equal");

        // Else if string1 not equal to string2, print saying so
        else
            System.out.println("String-1 and String-2 are not equal");

        // If string1 == string2, print
        if (string1 == string2)
            System.out.println("String-1 and String-2 are ==");

        // Else if not ==, print
        else
            System.out.println("String-1 and String-2 are not ==");

        // If string3 equals string4, print
        if (string3.equals(string4))
            System.out.println("String-3 and String-4 are equal");

        // Else if string3 not equal to string4, print
        else
            System.out.println("String-3 and String-4 are not equal");

        // If string3 == string4, print
        if (string3 == string4)
            System.out.println("String-3 and String-4 are ==");

        // Else if string3 not == string4, print
        else
            System.out.println("String-3 and String-4 are not ==");

        // Create upper case copies of string1 and string3
        String upper1 = string1.toUpperCase();
        String upper3 = string3.toUpperCase();

        // Print uppercase copies
        System.out.println(upper1);
        System.out.println(upper3);

        // If string1 is case-insensitive-equal-to the new uppercase copy of
        // string1, print
        if (string1.equalsIgnoreCase(upper1))
            System.out
                    .println("String-1 and Upper-1 are equal (ignoring case)");

        // Else print that they are not equal
        else
            System.out
                    .println("String-1 and Upper-1 are not equal (ignoring case)");

        // verify the version of Java that is running
        System.out.println(System.getProperty("java.version"));
    }
}
