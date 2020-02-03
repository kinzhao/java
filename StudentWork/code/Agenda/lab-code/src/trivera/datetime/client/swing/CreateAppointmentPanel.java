package trivera.datetime.client.swing;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.time.DayOfWeek;
import java.time.LocalTime;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
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
public class CreateAppointmentPanel extends JPanel {

	private JRadioButton rdbtnAt = new JRadioButton("At");
	private JRadioButton rdbtnEveryXMinutes = new JRadioButton("Every");
	private JRadioButton rdbtnEveryDay = new JRadioButton("Every");
	private JRadioButton rdbtnFirstDayOf = new JRadioButton("First Day of Next month");

	private JTextArea descriptionArea;
	private JSpinner everyMinuteSpinner = new JSpinner();
	private JSpinner everyDaySpinner = new JSpinner();
	private JSpinner hourSpinner = new JSpinner();
	private JSpinner minuteSpinner = new JSpinner();

	private AppointmentFactory appointmentFactory;

	private SingleAppointmentPanel singleAppointmentPanel = new SingleAppointmentPanel();

	public CreateAppointmentPanel(JTextArea descriptionArea) {
		this.descriptionArea = descriptionArea;
		init();

	}

	public void init() {
		appointmentFactory = new AppointmentFactory(AgendaManager.getInstance());
		setBackground(AgendaClient.DEFAULT_COLOR);

		setLayout(new GridLayout(0, 1));
		add(createAtPanel());
		add(createFirstDayPanel());
		add(createEveryMinutePanel());
		add(createEveryDayPanel());
		add(createButtonPanel());

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnAt);
		bg.add(rdbtnEveryXMinutes);
		bg.add(rdbtnEveryDay);
		bg.add(rdbtnFirstDayOf);
		rdbtnAt.setSelected(true);

	}

	private JPanel createButtonPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(AgendaClient.DEFAULT_COLOR);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton createButton = new JButton("Create");
		createButton.addActionListener(event -> {
			createAppointment();
			descriptionArea.setText("");

		});
		panel.add(createButton);
		return panel;
	}

	private void createAppointment() {
		if (rdbtnAt.isSelected()) {
			singleAppointmentPanel.createAppointment(descriptionArea.getText());
		} else if (rdbtnEveryXMinutes.isSelected()) {

			Integer minutes = (Integer) this.everyMinuteSpinner.getValue();
			appointmentFactory.createRepeatingAppointment(descriptionArea.getText(), minutes);
		} else if (rdbtnEveryDay.isSelected()) {
			Integer minutes = (Integer) this.minuteSpinner.getValue();
			Integer hours = (Integer) this.hourSpinner.getValue();
			DayOfWeek dayOfWeek = (DayOfWeek) this.everyDaySpinner.getValue();
			appointmentFactory.createDayAppointments(descriptionArea.getText(), hours, minutes, dayOfWeek);
		} else if (rdbtnFirstDayOf.isSelected()) {
			appointmentFactory.createFirstDayOfNextMonthAppointment(descriptionArea.getText());
		}

	}

	/*
	 * Create Panel for particular moment in time
	 */
	private JPanel createAtPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(AgendaClient.DEFAULT_COLOR);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));

		rdbtnAt.setBackground(AgendaClient.DEFAULT_COLOR);

		panel.add(rdbtnAt);

		rdbtnAt.addChangeListener(event -> singleAppointmentPanel.enableFields(rdbtnAt.isSelected()));
		panel.add(singleAppointmentPanel);
		return panel;
	}

	/*
	* 
	*
	*/
	private JPanel createFirstDayPanel() {
		JPanel panel = new JPanel();

		panel.setBackground(AgendaClient.DEFAULT_COLOR);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));

		rdbtnFirstDayOf.setBackground(AgendaClient.DEFAULT_COLOR);
		panel.add(rdbtnFirstDayOf);
		return panel;
	}

	private JPanel createEveryMinutePanel() {
		JPanel panel = new JPanel();
		panel.setBackground(AgendaClient.DEFAULT_COLOR);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));

		rdbtnEveryXMinutes.setBackground(AgendaClient.DEFAULT_COLOR);
		panel.add(rdbtnEveryXMinutes);

		everyMinuteSpinner.setModel(new SpinnerNumberModel(1, 1, 60, 1));
		panel.add(everyMinuteSpinner);

		rdbtnEveryXMinutes.addChangeListener((event) -> everyMinuteSpinner.setEnabled(rdbtnEveryXMinutes.isSelected()));

		JLabel lblNewLabel = new JLabel("Minutes");
		panel.add(lblNewLabel);
		return panel;
	}

	private JPanel createEveryDayPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(AgendaClient.DEFAULT_COLOR);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));

		rdbtnEveryDay.setBackground(AgendaClient.DEFAULT_COLOR);
		panel.add(rdbtnEveryDay);

		DayOfWeek[] values = DayOfWeek.values();

		everyDaySpinner.setModel(new SpinnerListModel(values));

		panel.add(everyDaySpinner);

		JLabel lblAt = new JLabel("at");
		panel.add(lblAt);
		LocalTime time = LocalTime.now();
		SpinnerModel hourModel = new SpinnerNumberModel(time.getHour(), 0, 23, 1);
		SpinnerModel minuteModel = new SpinnerNumberModel(time.getMinute(), 0, 59, 1);

		hourSpinner.setModel(hourModel);
		hourSpinner.setEditor(new JSpinner.NumberEditor(hourSpinner, "00"));
		panel.add(hourSpinner);

		minuteSpinner.setModel(minuteModel);
		minuteSpinner.setEditor(new JSpinner.NumberEditor(minuteSpinner, "00"));
		panel.add(minuteSpinner);

		rdbtnEveryDay.addChangeListener((event) -> {
			everyDaySpinner.setEnabled(rdbtnEveryDay.isSelected());
			hourSpinner.setEnabled(rdbtnEveryDay.isSelected());
			minuteSpinner.setEnabled(rdbtnEveryDay.isSelected());
		});
		return panel;
	}

}
