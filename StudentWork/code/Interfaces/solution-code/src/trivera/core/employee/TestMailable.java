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


public class TestMailable {
    public static void main(String[] args) {
        Mailable mailable[] = new Mailable[4];

        Company trivera = new Company();
        Company sun = new Company();
        SalesEmployee jennifer = new SalesEmployee("Jennifer", 23);
        HourlyEmployee john = new HourlyEmployee("John Wirth", 35);

        mailable[0] = trivera;
        mailable[1] = jennifer;
        mailable[2] = john;
        mailable[3] = sun;

        for (int i = 0; i < mailable.length; i++) {
            mailable[i].mailNote("Hello, here a note from me");

        }
        // verify the version of Java that is running
        System.out.println(System.getProperty("java.version"));
    }
}