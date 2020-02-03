package trivera.jdbc.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

public class ReadRows {

    public static void main(java.lang.String[] args) {

        // verify the version of Java that is running
        System.out.println(System.getProperty("java.version"));

        Statement statement;
        ResultSet resultSet;
        String firstName, lastName;
        int empId;
        double salary;

        /*
         * The default information used here assumes you will be connecting to a
         * Derby database.
         * Feel free to change this default if you wish.
         *
         * The JDBC driver to connect to Derby is 
         * org.apache.derby.jdbc.ClientDriver.
         */
      
            // Connect to the database using the driver created.

            try(Connection conn = DriverManager.getConnection(
                    "jdbc:derby://localhost:50505/Personnel;user=sa;password=password");){

            // retrieve a statement object from the connection
            statement = conn.createStatement();

            // Execute a query to obtain all the rows and columns in the
            // Employee table.
            resultSet = statement.executeQuery("SELECT EMPID, FIRSTNAME, LASTNAME, SALARY FROM EMPLOYEE");

            // Loop through the result set, extracting the EMPID, FIRSTNAME, LASTNAME, and SALARY
        	// from each row
            while (resultSet.next()) {
                empId = resultSet.getInt("EMPID");
                firstName = resultSet.getString("FIRSTNAME");
                lastName = resultSet.getString("LASTNAME");
                salary = resultSet.getDouble("SALARY");

                // For each row, print out the four columns on a line

                System.out.println(empId + "  " + firstName + " " + lastName
                        + " " + salary);
            }

        } catch (SQLException sqle) {
            System.err.println("DB Error ");
            sqle.printStackTrace();

        }

    }
}
