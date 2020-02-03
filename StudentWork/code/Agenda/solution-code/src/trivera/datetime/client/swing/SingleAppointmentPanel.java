package trivera.datetime.client.swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import trivera.datetime.appointment.AppointmentFactory;
import trivera.datetime.client.AgendaClient;

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
@SuppressWarnings("serial")
public class SingleAppointmentPanel extends JPanel {
	private JSpinner daySpinner = new JSpinner();
	private JSpinner monthSpinner = new JSpinner();
	private JSpinner yearSpinner = new JSpinner();
	private JSpinner hourSpinner = new JSpinner();
	private JSpinner minuteSpinner = new JSpinner();
	private JCheckBox dailyBox = new JCheckBox("Daily");

	private AppointmentFactory appointmentFactory;

	public SingleAppointmentPanel() {
		init();
	}

	public void createAppointment(String description) {

		Integer day = (Integer) daySpinner.getValue();
		Month month = (Month) monthSpinner.getValue();
		Integer year = (Integer) yearSpinner.getValue();
		Integer hour = (Integer) hourSpinner.getValue();
		Integer minute = (Integer) minuteSpinner.getValue();

		if (dailyBox.isSelected()) {
			appointmentFactory.createDailyAppointment(description, year, month.getValue(), day, hour, minute);
		} else {
			appointmentFactory.createAppointment(description, year, month.getValue(), day, hour, minute);
		}
	}

	public void enableFields(boolean enabled) {
		daySpinner.setEnabled(enabled);
		monthSpinner.setEnabled(enabled);
		yearSpinner.setEnabled(enabled);
		hourSpinner.setEnabled(enabled);
		minuteSpinner.setEnabled(enabled);
		dailyBox.setEnabled(enabled);
	}

	private void init() {
		appointmentFactory = new AppointmentFactory(AgendaManager.getInstance());

		setBackground(AgendaClient.DEFAULT_COLOR);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 29, 79, 29, 47, 29, 29, 39, 56, 0 };
		gridBagLayout.rowHeights = new int[] { 17, 14, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		LocalDate now = LocalDate.now();

		SpinnerModel dayModel = new SpinnerNumberModel(now.getDayOfMonth(), 1, 31, 1);
		SpinnerModel monthModel = new SpinnerListModel(Month.values());

		int year = Year.now().getValue();
		SpinnerModel yearModel = new SpinnerNumberModel(year, year, year + 4, 1);

		LocalTime time = LocalTime.now().plusMinutes(1);
		SpinnerModel hourModel = new SpinnerNumberModel(time.getHour(), 0, 23, 1);
		SpinnerModel minuteModel = new SpinnerNumberModel(time.getMinute(), 0, 59, 1);

		JLabel lblDate = new JLabel("Date:");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 0;
		add(lblDate, gbc_lblDate);

		JLabel lblTime = new JLabel("Time:");
		GridBagConstraints gbc_lblTime = new GridBagConstraints();
		gbc_lblTime.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblTime.gridx = 4;
		gbc_lblTime.gridy = 0;
		add(lblTime, gbc_lblTime);

		daySpinner.setModel(dayModel);
		daySpinner.setEditor(new JSpinner.NumberEditor(daySpinner, "00"));
		GridBagConstraints gbc_daySpinner = new GridBagConstraints();
		gbc_daySpinner.anchor = GridBagConstraints.WEST;
		gbc_daySpinner.insets = new Insets(0, 0, 0, 5);
		gbc_daySpinner.gridx = 0;
		gbc_daySpinner.gridy = 1;
		add(daySpinner, gbc_daySpinner);

		monthSpinner.setModel(monthModel);
		monthSpinner.setEditor(new JSpinner.DefaultEditor(monthSpinner));
		monthModel.setValue(now.getMonth());
		GridBagConstraints gbc_monthSpinner = new GridBagConstraints();
		gbc_monthSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_monthSpinner.insets = new Insets(0, 0, 0, 5);
		gbc_monthSpinner.gridx = 1;
		gbc_monthSpinner.gridy = 1;
		add(monthSpinner, gbc_monthSpinner);

		yearSpinner.setModel(yearModel);
		yearSpinner.setEditor(new JSpinner.NumberEditor(yearSpinner, "#"));
		GridBagConstraints gbc_yearSpinner = new GridBagConstraints();
		gbc_yearSpinner.anchor = GridBagConstraints.WEST;
		gbc_yearSpinner.insets = new Insets(0, 0, 0, 5);
		gbc_yearSpinner.gridx = 2;
		gbc_yearSpinner.gridy = 1;
		add(yearSpinner, gbc_yearSpinner);

		hourSpinner.setModel(hourModel);
		hourSpinner.setEditor(new JSpinner.NumberEditor(hourSpinner, "00"));
		GridBagConstraints gbc_hourSpinner = new GridBagConstraints();
		gbc_hourSpinner.anchor = GridBagConstraints.WEST;
		gbc_hourSpinner.insets = new Insets(0, 0, 0, 5);
		gbc_hourSpinner.gridx = 4;
		gbc_hourSpinner.gridy = 1;
		add(hourSpinner, gbc_hourSpinner);

		minuteSpinner.setModel(minuteModel);
		minuteSpinner.setEditor(new JSpinner.NumberEditor(minuteSpinner, "00"));
		GridBagConstraints gbc_minuteSpinner = new GridBagConstraints();
		gbc_minuteSpinner.anchor = GridBagConstraints.WEST;
		gbc_minuteSpinner.insets = new Insets(0, 0, 0, 5);
		gbc_minuteSpinner.gridx = 5;
		gbc_minuteSpinner.gridy = 1;
		add(minuteSpinner, gbc_minuteSpinner);

		dailyBox.setBackground(AgendaClient.DEFAULT_COLOR);
		GridBagConstraints gbc_dailyBox = new GridBagConstraints();
		gbc_dailyBox.anchor = GridBagConstraints.NORTH;
		gbc_dailyBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_dailyBox.gridx = 7;
		gbc_dailyBox.gridy = 1;
		add(dailyBox, gbc_dailyBox);
	}

}
