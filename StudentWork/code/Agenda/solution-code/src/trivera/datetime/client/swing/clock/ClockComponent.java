package trivera.datetime.client.swing.clock;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;

import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import trivera.datetime.client.AgendaClient;
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
public class ClockComponent extends JComponent implements ChangeListener {
	private static final long serialVersionUID = 1L;

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
			"E dd-MMM-yyyy");
	private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat(
			"hh:mm a");
	private Long currentTime = System.currentTimeMillis();
	private Long milliSecondsToUpdate = 100l;

	private Calendar _now = Calendar.getInstance();

	private int clockDiameter; // Height and width of clock face
	private int centerX; // x coord of middle of clock
	private int centerY; // y coord of middle of clock
	private BufferedImage clockImage;

	private javax.swing.Timer timer;

	public ClockComponent() {
		setPreferredSize(new Dimension(160, 220));
		timer = new javax.swing.Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTime();
				repaint();
			}
		});
	}

	public void startClock() {
		timer.start();
	}

	/** Stop the timer. */
	public void stopClock(long time) {
		timer.stop();
		currentTime = time;
		repaint();
	}

	/** Stop the timer. */
	public void stopClock() {
		timer.stop();
	}

	private void updateTime() {
		currentTime = currentTime + milliSecondsToUpdate;
		_now.setTimeInMillis(currentTime);
		AgendaManager.getInstance().showAppointments(

				LocalDateTime.ofInstant(Instant.ofEpochMilli(currentTime),
						ZoneId.systemDefault()));
	}

	// ======================================================= paintComponent
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		int w = 150;
		int h = 150;
		clockDiameter = 148;
		centerX = clockDiameter / 2;
		centerY = clockDiameter / 2;
		if (clockImage == null || clockImage.getWidth() != w
				|| clockImage.getHeight() != h) {
			clockImage = (BufferedImage) (this.createImage(w, h));

			Graphics2D g2a = clockImage.createGraphics();
			g2a.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			drawClockFace(g2a);
		}

		// ... Draw the clock face from the precomputed image
		g2.drawImage(clockImage, null, 0, 0);

		// ... Draw the clock hands dynamically each time.
		drawClockHands(g2);
	}

	// ====================================== convenience method drawClockHands
	private void drawClockHands(Graphics2D g2) {
		// ... Get the various time elements from the Calendar object.
		int hours = _now.get(Calendar.HOUR);
		int minutes = _now.get(Calendar.MINUTE);
		int seconds = _now.get(Calendar.SECOND);
		int millis = _now.get(Calendar.MILLISECOND);

		int handMax = (clockDiameter / 2) - 5;
		double fseconds = (seconds + (double) millis / 1000) / 60.0;
		// ... second hand
		if (milliSecondsToUpdate < 10000) {
			drawLine(g2, fseconds, 0, handMax, 2, Color.RED);
		}
		// ... minute hand
		handMax = clockDiameter / 3;
		double fminutes = (minutes + fseconds) / 60.0;
		drawLine(g2, fminutes, 0, handMax, 5, Color.BLACK);

		// ... hour hand
		handMax = clockDiameter / 4;
		drawLine(g2, (hours + fminutes) / 12.0, 0, handMax, 5, Color.BLACK);

		g2.setFont(new Font("TimesRoman", Font.BOLD, 18));
		String dateString = DATE_FORMAT.format(_now.getTime());
		g2.drawString(dateString, 25, 175);

		String timeString = TIME_FORMAT.format(_now.getTime());
		g2.drawString(timeString, 50, 195);
	}

	// ======================================= convenience method drawClockFace
	private void drawClockFace(Graphics2D g2) {
		// ... Draw the clock face. Probably into a buffer.
		g2.setColor(AgendaClient.DEFAULT_COLOR);
		g2.setBackground(getBackground());
		g2.clearRect(0, 0, 150, 150);
		g2.setColor(Color.WHITE);
		g2.fillOval(0, 0, clockDiameter, clockDiameter);
		g2.setColor(Color.BLACK);
		g2.drawOval(0, 0, clockDiameter, clockDiameter);

		int radius = clockDiameter / 2;

		// ... Draw the tick marks around the circumference.
		for (int sec = 0; sec < 60; sec++) {
			int tickStart;
			if (sec % 5 == 0) {
				tickStart = radius - 10; // Draw long tick mark every 5.
			} else {
				tickStart = radius - 5; // Short tick mark.
			}
			drawLine(g2, sec / 60.0, tickStart, radius, 1, Color.BLACK);
		}

		g2.setFont(new Font("TimesRoman", Font.BOLD, 18));
		g2.drawString("9", centerX - 60, centerY + 5);
		g2.drawString("3", centerX + 55, centerY + 5);
		g2.drawString("6", centerX - 3, centerY + 60);
		g2.drawString("12", centerX - 6, centerY - 50);

	}

	/**
	 * 
	 * @param g2
	 * @param percent
	 * @param minRadius
	 * @param maxRadius
	 * @param lineThicknes
	 * @param lineColor
	 */
	private void drawLine(Graphics2D g2, double percent, int minRadius,
			int maxRadius, int lineThicknes, Color lineColor) {

		double radians = (0.5 - percent) * (2.0 * Math.PI);
		double sine = Math.sin(radians);
		double cosine = Math.cos(radians);
		int dxmin = centerX + (int) (minRadius * sine);
		int dymin = centerY + (int) (minRadius * cosine);
		int dxmax = centerX + (int) (maxRadius * sine);
		int dymax = centerY + (int) (maxRadius * cosine);
		g2.setColor(lineColor);
		g2.setStroke(new BasicStroke(lineThicknes));
		g2.drawLine(dxmin, dymin, dxmax, dymax);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		Object source = e.getSource();
		if (source instanceof JSlider) {
			JSlider sliders = (JSlider) e.getSource();
			if (!sliders.getValueIsAdjusting()) {
				milliSecondsToUpdate = (long) sliders.getValue();
			}
		}

	}

	public void setTime(Long timeMillis) {
		currentTime = timeMillis;
		_now.setTimeInMillis(currentTime);
		repaint();
	}

	public void reset() {
		currentTime = System.currentTimeMillis();
	}

	public void setMilliSecondsToUpdate(long value) {
		milliSecondsToUpdate = value;
	}
}
