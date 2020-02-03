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
        
        // Create the RowSetFactory
        try{
        	rowSetFactory = RowSetProvider.newFactory();
        }
        catch (SQLException sqle){
        	System.out.println("RowSetFactory failed");
        	System.exit(-1);
        }
  
        // Using try-with-resources, create the JdbcRowSet
        try (JdbcRowSet jdbcRowSet = rowSetFactory.createJdbcRowSet();){
        	jdbcRowSet.setUrl("jdbc:derby://localhost:50505/Personnel;user=sa;password=password");

            // Execute a query to obtain all the rows and columns in the
            // Employee table.      
        	jdbcRowSet.setCommand("Select * from Employee");
        	jdbcRowSet.execute();


            // Loop through the result set, extracting the EMPID, FIRSTNAME, LASTNAME, and SALARY
        	// from each row
            while (jdbcRowSet.next()) {
                empId = jdbcRowSet.getInt("EMPID");
                firstName = jdbcRowSet.getString("FIRSTNAME");
                lastName = jdbcRowSet.getString("LASTNAME");
                salary = jdbcRowSet.getDouble("SALARY");

                // For each row, print out the four columns on a line

                System.out.println(empId + "  " + firstName + " " + lastName
                        + " " + salary);
            }
            
            // Insert a new Employee
            jdbcRowSet.moveToInsertRow();
            jdbcRowSet.updateInt("EMPID", 1111);
            jdbcRowSet.updateString("FIRSTNAME", "Olaf");
            jdbcRowSet.updateString("LASTNAME", "Schmidt");
            jdbcRowSet.updateDouble("SALARY", 25000);
            jdbcRowSet.insertRow();
            
            System.out.println("Verify that row was inserted");
            
            // Pull out the individual pieces of the row and print just that row
            int id = jdbcRowSet.getInt("EMPID");
            String fName = jdbcRowSet.getString("FIRSTNAME");
            String lName = jdbcRowSet.getString("LASTNAME");
            double pay = jdbcRowSet.getDouble("SALARY");
            System.out.println(id+ "  " + fName+"  "+ lName+"  "+pay);

        } catch (SQLException sqle) {
            System.err.println("DB Error ");
            sqle.printStackTrace();
        }
    }
}
