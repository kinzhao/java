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


public class Passenger {
    private String name;
    private int frequentFlyerMiles;
    private int memberLevel;
    
	public Passenger() {
	}

	public Passenger(String name, int frequentFlyerMiles, int memberLevel) {
		this.name = name;
		this.frequentFlyerMiles = frequentFlyerMiles;
		this.memberLevel = memberLevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFrequentFlyerMiles() {
		return frequentFlyerMiles;
	}

	public void setFrequentFlyerMiles(int frequentFlyerMiles) {
		this.frequentFlyerMiles = frequentFlyerMiles;
	}

	public int getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(int memberLevel) {
		this.memberLevel = memberLevel;
	}

    


}
