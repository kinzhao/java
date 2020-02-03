package trivera.jdbc.rowsets;


import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

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

public class UsingRowSets {

    public static void main(java.lang.String[] args) {

        // verify the version of Java that is running
        System.out.println(System.getProperty("java.version"));

        String firstName, lastName;
        int empId;
        double salary;
        RowSetFactory rowSetFactory=null;

        /*
         * Default information used here assumes you will be connecting to a
         * Derby database.
         * Feel free to change this default if you wish.
         *
         * The JDBC driver to connect to Derby is 
         * org.apache.derby.jdbc.ClientDriver.
         */
        
        // LAB HINT: Create the RowSetFactory
        try{
        	
        }
        catch (SQLException sqle){
        	System.out.println("RowSetFactory failed");
        	System.exit(-1);
        }
  
        // LAB HINT: Using try-with-resources, create the JdbcRowSet
        // LAB HINT: the URL is jdbc:derby://localhost:50505/Personnel;user=sa;password=password
        try {
        	
        // LAB HINT: See the lab manual for more instructions
        	
        } catch (SQLException sqle) {
            System.err.println("DB Error ");
            sqle.printStackTrace();
        }
    }
}
