package trivera.datetime.client.swing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import trivera.datetime.appointment.Appointment;
import trivera.datetime.client.Agenda;

/**
 * <p>
 * This component and its source code representation are copyright protected and
 * proprietary to Trivera Technologies, LLC, Worldwide D/B/A Trivera
 * Technologies
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
public class AgendaManager implements AppointmentScheduler {

	private Agenda agenda = new Agenda();
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM uuuu  kk:mm");
	private static AgendaManager currentInstance;

	private List<AgendaListener> agendaListeners = new ArrayList<>();

	private AgendaManager() {

	}

	public static AgendaManager getInstance() {
		if (currentInstance == null) {
			currentInstance = new AgendaManager();
		}
		return currentInstance;
	}

	public void addAppointment(Appointment appointment) {
		agenda.addAppointment(appointment);
		fireAgendaChangedEvent();
	}

	public void clearAllAppointments() {
		agenda.clearAllAppointments();
		fireAgendaChangedEvent();
	}

	public void addAppointments(Collection<Appointment> appointments) {
		this.agenda.addAppointments(appointments);
		fireAgendaChangedEvent();
	}

	public void showAppointments(LocalDateTime moment) {

		Appointment check = agenda.checkNextAppointment();

		while (check != null && !(check.getDateTime().isAfter(moment))) {
			Appointment appointment = agenda.getNextAppointment();
			LocalDateTime dateTime = appointment.getDateTime();

			String dateTimeFormat = formatter.format(dateTime);

			String description = appointment.getDescription();

			if (description == null || "".equals(description.trim())) {
				description = "n/a";
			}

			fireItemFoundEvent(dateTime, description);
			String message = String.format("%s\n Description: %s", dateTimeFormat, appointment.getDescription());

			JOptionPane.showMessageDialog(null, message, "Appointment", JOptionPane.INFORMATION_MESSAGE);
			check = agenda.checkNextAppointment();
			fireAgendaChangedEvent();
		}

	}

	private void fireItemFoundEvent(LocalDateTime dateTime, String description) {
		for (AgendaListener listener : this.agendaListeners) {
			listener.itemFound(dateTime, description);
		}
	}

	private void fireAgendaChangedEvent() {
		for (AgendaListener listener : this.agendaListeners) {
			listener.agendaChanged();
		}
	}

	public void addAgendaListener(AgendaListener listener) {
		this.agendaListeners.add(listener);
	}

	public Agenda getAgenda() {
		return this.agenda;
	}
}
