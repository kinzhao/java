package trivera.datetime.client.swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

import trivera.datetime.client.AgendaClient;

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
public class AppointmentPanel extends JPanel {
	public AppointmentPanel() {
		init();
	}

	private void init() {
		setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		setBackground(AgendaClient.DEFAULT_COLOR);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 446, 0 };
		gridBagLayout.rowHeights = new int[] { 35, 141, 211, 141, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblDescription = new JLabel("Description");
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.fill = GridBagConstraints.BOTH;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 0);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 0;
		add(lblDescription, gbc_lblDescription);

		JTextArea descriptionArea = new JTextArea(4, 60);
		descriptionArea.setBorder(new EtchedBorder(EtchedBorder.RAISED, null,
				null));
		GridBagConstraints gbc_descriptionArea = new GridBagConstraints();
		gbc_descriptionArea.fill = GridBagConstraints.VERTICAL;
		gbc_descriptionArea.insets = new Insets(0, 0, 5, 0);
		gbc_descriptionArea.gridx = 0;
		gbc_descriptionArea.gridy = 1;
		add(descriptionArea, gbc_descriptionArea);

		CreateAppointmentPanel createAppointmentPanel = new CreateAppointmentPanel(
				descriptionArea);
		GridBagConstraints gbc_createAppointmentPanel = new GridBagConstraints();
		gbc_createAppointmentPanel.fill = GridBagConstraints.VERTICAL;
		gbc_createAppointmentPanel.insets = new Insets(0, 0, 5, 0);
		gbc_createAppointmentPanel.gridx = 0;
		gbc_createAppointmentPanel.gridy = 2;
		add(createAppointmentPanel, gbc_createAppointmentPanel);

		ScheduledAppointmentsPanel scheduledAppointmentsPanel = new ScheduledAppointmentsPanel();
		GridBagConstraints gbc_scheduledAppointmentsPanel = new GridBagConstraints();
		gbc_scheduledAppointmentsPanel.fill = GridBagConstraints.BOTH;
		gbc_scheduledAppointmentsPanel.gridx = 0;
		gbc_scheduledAppointmentsPanel.gridy = 3;
		add(scheduledAppointmentsPanel, gbc_scheduledAppointmentsPanel);
	}
}
