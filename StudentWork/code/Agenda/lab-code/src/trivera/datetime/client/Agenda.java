package trivera.datetime.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import trivera.datetime.appointment.Appointment;

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
public class Agenda {

	private Queue<Appointment> appointments = new PriorityQueue<>();

	public void addAppointment(Appointment appointment) {
		this.appointments.add(appointment);
	}

	public void clearAllAppointments() {
		appointments.clear();
	}

	public List<Appointment> getAllAppointments() {
		List<Appointment> appointments = new ArrayList<>(this.appointments);
		Collections.sort(appointments);
		return appointments;
	}

	public void addAppointments(Collection<Appointment> appointments) {
		this.appointments.addAll(appointments);
	}

	public boolean hasAppointments() {
		return appointments.size() > 0;
	}

	public int getNumberOfAppointments() {
		return appointments.size();
	}

	public Appointment checkNextAppointment() {
		return appointments.peek();
	}

	public Appointment getNextAppointment() {
		return appointments.poll();
	}

}
