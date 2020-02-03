package trivera.datetime.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDateTime;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import trivera.datetime.client.swing.AgendaManager;
import trivera.datetime.client.swing.AppointmentPanel;
import trivera.datetime.client.swing.clock.ClockPanel;

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
public class AgendaClient extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Color DEFAULT_COLOR = new Color(238, 238, 238);
	private ClockPanel clockPanel = new ClockPanel();

	public AgendaClient() {

	}

	private AgendaManager agendaManager;

	public static void main(String[] args) {
		System.setProperty("sun.java2d.d3d", Boolean.FALSE.toString());

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new AgendaClient().init();
			}
		});

	}

	private void init() {
		agendaManager = AgendaManager.getInstance();
		setLookAndFeel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Agenda Client");

		createMenu();
		setLayout(new BorderLayout());
		add(clockPanel, BorderLayout.WEST);
		add(new AppointmentPanel(), BorderLayout.EAST);
		pack();

		setLocationRelativeTo(null); // Center window.
		setVisible(true);
		agendaManager.showAppointments(LocalDateTime.now());
	}

	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		JMenuItem clearAppointment = new JMenuItem("Clear appointments");
		clearAppointment.addActionListener(event -> AgendaManager.getInstance().clearAllAppointments());
		fileMenu.add(clearAppointment);

		JMenuItem resetTime = new JMenuItem("Reset Time");
		resetTime.addActionListener(event -> clockPanel.resetClock());

		fileMenu.add(resetTime);

		fileMenu.addSeparator();

		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(event -> System.exit(0));
		fileMenu.add(exit);

		this.setJMenuBar(menuBar);
	}

	private void setLookAndFeel() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// Ignore
		}
	}

}
