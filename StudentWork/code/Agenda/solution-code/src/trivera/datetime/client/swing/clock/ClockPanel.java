package trivera.datetime.client.swing.clock;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EtchedBorder;

import trivera.datetime.client.AgendaClient;
import trivera.datetime.client.swing.AgendaListener;
import trivera.datetime.client.swing.AgendaManager;

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
public class ClockPanel extends JPanel implements AgendaListener {
	private final ClockComponent clock = new ClockComponent();

	private int clockSpeed = 100;
	private JSlider speedSlider;

	public ClockPanel() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setBackground(AgendaClient.DEFAULT_COLOR);
		init();
	}

	private void init() {

		setLayout(new GridLayout(0, 1));

		JPanel graphicsPanel = new JPanel();
		graphicsPanel.setBackground(AgendaClient.DEFAULT_COLOR);
		clock.setBackground(AgendaClient.DEFAULT_COLOR);
		graphicsPanel.add(clock);
		add(graphicsPanel);

		add(createButtonPanel());

		AgendaManager.getInstance().addAgendaListener(this);
		clock.startClock();
	}

	private JPanel createButtonPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(AgendaClient.DEFAULT_COLOR);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton playButton = new JButton(">>");
		playButton.setToolTipText("Play");

		JButton pauseButton = new JButton("  ||  ");
		pauseButton.setToolTipText("Pause");

		playButton.setVisible(false);

		panel.add(playButton);
		panel.add(pauseButton);

		playButton.addActionListener(event -> {
			playButton.setVisible(false);
			pauseButton.setVisible(true);

			clock.startClock();
		});
		pauseButton.addActionListener(event -> {
			playButton.setVisible(true);
			pauseButton.setVisible(false);

			clock.stopClock();
		});

		speedSlider = new JSlider(JSlider.HORIZONTAL, clockSpeed, 50000, 100);
		speedSlider.addChangeListener(clock);

		speedSlider.addChangeListener(event -> clockSpeed = speedSlider
				.getValue());
		speedSlider.setPaintTicks(false);
		speedSlider.setToolTipText("Change clock speed");
		panel.add(speedSlider);

		JButton speedButton = new JButton("Faster");
		speedButton.addActionListener(event -> {
			increaseClockSpeed();
		});
		panel.add(speedButton);
		return panel;
	}

	public void itemFound(LocalDateTime dateTime, String description) {
		resetClock();
		long millis = dateTime.atZone(ZoneId.systemDefault()).toEpochSecond() * 1000;
		clock.setTime(millis);
	}

	public void resetClock() {
		clockSpeed = 100;
		speedSlider.setValue(100);
		clock.reset();
	}

	private void increaseClockSpeed() {
		clockSpeed = clockSpeed + 100000;
		if (clockSpeed < speedSlider.getMaximum()) {
			speedSlider.setValue(clockSpeed);
		} else {
			speedSlider.setValue(speedSlider.getMaximum());
		}
		clock.setMilliSecondsToUpdate(clockSpeed);
	}
}
