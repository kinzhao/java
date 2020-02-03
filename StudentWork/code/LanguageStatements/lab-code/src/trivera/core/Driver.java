package trivera.core;

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

public class Driver {

    public static void main(String[] args) {
       Passenger passenger1 = new Passenger("Fred", 16500,3);
       Passenger passenger2 = new Passenger("Wilma", 0,1);
       Passenger passenger3 = new Passenger("Barney", 8500,2);
       Passenger passenger4 = new Passenger("Betty", 4500,1);
       
       Airport airport = new Airport();
       airport.checkIn(passenger1);
       airport.checkIn(passenger2);
       airport.checkIn(passenger3);
       airport.checkIn(passenger4);
       
    }

}