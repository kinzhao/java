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

public class StringBuffers {

    public static void main(java.lang.String[] args) {

        // Create a new StringBuffer
        StringBuffer buffer = new StringBuffer();

        // Add a string to the buffer
        buffer.append("Hello");

        // Add another string to the buffer
        buffer.append(" - you wonderful person, you!!");

        // Convert the buffer to a string
        String string = buffer.toString();

        // Create a new StringBuffer, initialized with the string
        buffer = new StringBuffer(string);

        // Add another string to the new string buffer
        buffer.append(" Good-Bye!!");

        // Convert the new string buffer to a string
        string = buffer.toString();

        // Print out the string
        System.out.println(string);

        // Create a new StringBuffer
        StringBuilder builder = new StringBuilder();

        // Add a string to the buffer
        builder.append("Hello");

        // Add another string to the buffer
        builder.append(" - you wonderful builder, you!!");

        // Convert the buffer to a string
        string = builder.toString();

        // Create a new StringBuffer, initialized with the string
        builder = new StringBuilder(string);

        // Add another string to the new string buffer
        builder.append(" Good-Bye!!");

        // Convert the new string buffer to a string
        string = builder.toString();

        // Print out the string
        System.out.println(string);

        // verify the version of Java that is running
        System.out.println(System.getProperty("java.version"));
    }
}
