package trivera.datetime.client.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

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
 @SuppressWarnings("serial")
public class ScheduledAppointmentsPanel extends JPanel {
	private static final DateTimeFormatter dateformatter = DateTimeFormatter
			.ofPattern("dd MMMM uuuu");
	private static final DateTimeFormatter timeformatter = DateTimeFormatter
			.ofPattern("hh:mm a");

	private AgendaTableModel model = new AgendaTableModel();

	public ScheduledAppointmentsPanel() {
		init();
	}

	private void init() {
		this.setLayout(new BorderLayout());

		JTable table = new JTable(model);

		JButton btnNewButton = new JButton("Clear Appointments");
		add(btnNewButton, BorderLayout.SOUTH);
		btnNewButton.addActionListener(event -> {
			AgendaManager.getInstance().clearAllAppointments();
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(table);
		scrollPane.setPreferredSize(new Dimension(100, 100));
		table.setFillsViewportHeight(true);

		add(scrollPane, BorderLayout.CENTER);
	}

	class AgendaTableModel extends AbstractTableModel implements AgendaListener {

		private AgendaManager agendaManager = AgendaManager.getInstance();

		public AgendaTableModel() {
			agendaManager.addAgendaListener(this);
		}

		@Override
		public int getRowCount() {
			return agendaManager.getAgenda().getNumberOfAppointments();
		}

		@Override
		public int getColumnCount() {
			return 4;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			List<Appointment> appointments = agendaManager.getAgenda()
					.getAllAppointments();
			Appointment appointment = appointments.get(rowIndex);
			LocalDateTime dateTime = appointment.getDateTime();
			switch (columnIndex) {

			case 1:
				return dateTime.getDayOfWeek().getDisplayName(TextStyle.FULL,
						Locale.getDefault());
			case 2:
				return dateformatter.format(dateTime);

			case 3:
				return timeformatter.format(dateTime);
			default:
				return appointment.getDescription();

			}

		}

		@Override
		public String getColumnName(int column) {
			switch (column) {
			case 1:
				return "Day";
			case 2:
				return "Date";
			case 3:
				return "Time";
			default:
				return "Description";

			}
		}

		@Override
		public void agendaChanged() {

			fireTableDataChanged();

		}

	}
}
