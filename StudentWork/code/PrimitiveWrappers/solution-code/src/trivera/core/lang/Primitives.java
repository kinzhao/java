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


public class Primitives {

    public static void main(java.lang.String[] args) {

        String intString = new String("55");
        String longString = new String("5000");
        String floatString = new String("25.95");
        String doubleString = new String("59.999995");

        int intVal = 55;
        long longVal = 5000;
        float floatVal = 25.95F;
        double doubleVal = 59.999995;

        // Declare the primitive wrapper classes

        Integer intObj;
        Long longObj;
        Float floatObj;
        Double doubleObj;

        // Instantiate the primitive wrapper instances from the Strings provided

        intObj = new Integer(intString);
        longObj = new Long(longString);
        floatObj = new Float(floatString);
        doubleObj = new Double(doubleString);

        // Compare the primitives to the primitive wrappers to see if they are
        // equal

        if (intVal == intObj.intValue())
            System.out.println("The ints match");

        if (longVal == longObj.longValue())
            System.out.println("The longs match");

        if (floatVal == floatObj.floatValue())
            System.out.println("The floats match");

        if (doubleVal == doubleObj.doubleValue())
            System.out.println("The doubles match");

        // verify the version of Java that is running
        System.out.println(System.getProperty("java.version"));
    }
}
