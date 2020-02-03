package trivera.core.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;


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

public class HashtableTest {

    public static void main(java.lang.String[] args) {

        // Create an Map using Hashtable.

        Map<String, String> myTable = new Hashtable<String, String>();

        // Add the six objects to the Map.

        myTable.put("CA", "California");
        myTable.put("ID", "Idaho");
        myTable.put("NJ", "New Jersey");
        myTable.put("WA", "Washington");
        myTable.put("TX", "Texas");
        myTable.put("CO", "Colorado");

        // Extract a single value and print it

        System.out.println(myTable.get("ID") + ": Single Extraction");

        // Create sets of keys and entries.

        Set<String> keys = myTable.keySet();
        Collection<String> values = myTable.values();
        Iterator<String> keyIterator = keys.iterator();

        System.out.println("Keys:");
        while(keyIterator.hasNext()) {
            String s = keyIterator.next();
            System.out.println(s);
         };

         Iterator<String> valueIterator = values.iterator();

         System.out.println("\n\nValues:");
         while(valueIterator.hasNext()) {
             String item = valueIterator.next();
             System.out.println(item);
          };

        // verify the version of Java that is running
        System.out.println(System.getProperty("java.version"));
    }
}