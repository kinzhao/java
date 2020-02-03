package trivera.core.enumerations;

/**
 * Enumeration, containing information about the 50 states
 *
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

public enum USState {
        AL("Alabama","Montgomery"),
        AK("Alaska","Juneau"),
        AZ("Arizona","Phoenix"),
        AR("Arkansas","Little Rock"),
        CA("California","Sacramento"),
        CO("Colorado","Denver"),
        CT("Connecticut","Hartford"),
        DE("Delaware","Dover"),
        FL("Florida","Tallahassee"),
        GA("Georgia","Atlanta"),
        HI("Hawaii","Honolulu"),
        ID("Idaho","Boise"),
        IL("Illinois","Springfield"),
        IN("Indiana","Indianapolis"),
        IA("Iowa","Des Moines"),
        KS("Kansas","Topeka"),
        KY("Kentucky","Frankfort"),
        LA("Louisiana","Baton Rouge"),
        ME("Maine","Augusta"),
        MD("Maryland","Annapolis"),
        MA("Massachusetts","Boston"),
        MI("Michigan","Lansing"),
        MN("Minnesota","St. Paul"),
        MS("Mississippi","Jackson"),
        MO("Missouri","Jefferson City"),
        MT("Montana","Helena"),
        NE("Nebraska","Lincoln"),
        NV("Nevada","Carson City"),
        NH("New Hampshire","Concord"),
        NJ("New Jersey","Trenton"),
        NM("New Mexico","Santa Fe"),
        NY("New York","Albany"),
        NC("North Carolina","Raleigh"),
        ND("North Dakota","Bismarck"),
        OH("Ohio","Columbus"),
        OK("Oklahoma","Oklahoma City"),
        OR("Oregon","Salem"),
        PA("Pennsylvania","Harrisburg"),
        RI("Rhode Island","Providence"),
        SC("South Carolina","Columbia"),
        SD("South Dakota","Pierre"),
        TN("Tennessee","Nashville"),
        TX("Texas","Austin"),
        UT("Utah","Salt Lake City"),
        VT("Vermont","Montpelier"),
        VA("Virginia","Richmond"),
        WA("Washington","Olympia"),
        WV("West Virginia","Charleston"),
        WI("Wisconsin","Madison"),
        WY("Wyoming","Cheyenne");

    //define two private constants of type String, called stateName and stateCapital
    private final String stateName;
    private final String stateCapital;

    /*
       Create a constructor for this Enum that takes the stateName and stateCapital as String objects
       Set the value of the two constants to the values of these arguments
    */
    USState(String stateName,String stateCapital){
        this.stateName = stateName;
        this.stateCapital = stateCapital;
    }

    //Define two getter methods to return the values of stateName and stateCapitol
    public String getStateName(){ return stateName; }
    public String getStateCapital(){ return stateCapital; }
}
