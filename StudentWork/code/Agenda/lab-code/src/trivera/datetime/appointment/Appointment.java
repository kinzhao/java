package trivera.datetime.appointment;

import java.time.LocalDateTime;

/**
 * <p>
 * This component and its source code representation are copyright protected and
 * proprietary to Trivera Technologies, LLC, Worldwide D/B/A Trivera Technologies
 *
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of the Trivera
 * Group, Inc.
 *
 * Copyright (c) 2020 Trivera Technologies, LLC. http://www.triveratech.com
 * 
 * </p>
 * 
 * @author Trivera Technologies Tech Team.
 */
public class Appointment implements Comparable<Appointment> {

	private String description;
	private LocalDateTime dateTime;

	public Appointment(String description, LocalDateTime dateTime) {
		super();
		this.description = description;
		this.dateTime = dateTime;
	}

	public String getDescription() {
		return description;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	@Override
	public int compareTo(Appointment other) {

		return dateTime.compareTo(other.dateTime);
	}

}
