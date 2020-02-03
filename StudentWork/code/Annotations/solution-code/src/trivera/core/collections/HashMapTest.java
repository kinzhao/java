package trivera.core.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

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

@SuppressWarnings({"unchecked","rawtypes"})
public class HashMapTest {

    public static void main(java.lang.String[] args) {

        // LAB HINT: Create a Map using HashMap.
        Map myMap = new HashMap<String, String>();

        // LAB HINT: Add the six objects to the Map.

        myMap.put("CA", "California");
        myMap.put("ID", "Idaho");
        myMap.put("NJ", "New Jersey");
        myMap.put("WA", "Washington");
        myMap.put("TX", "Texas");
        myMap.put("CO", "Colorado");

        // LAB HINT: Extract a single value and print it

        System.out.println(myMap.get("ID") + ": Single Extraction\n\n");

        // LAB HINT: Create sets of keys and entries.

        Set keys = myMap.keySet();
        Set values = myMap.entrySet();

        // LAB HINT: Use the iterators to print out the keys and
        //           values of the myMap.
        Iterator it = keys.iterator();
        System.out.println("Keys:");
        while(it.hasNext()) {
            String s = (String)it.next();
            System.out.println(s);
         };

         it = values.iterator();
         System.out.println("\n\nValues:");
         while(it.hasNext()) {
             Entry s = (Entry)it.next();
             System.out.println(s.getValue());
          };

    }
}
