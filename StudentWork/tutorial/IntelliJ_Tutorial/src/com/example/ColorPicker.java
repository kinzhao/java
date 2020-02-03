package com.example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * <p>
 * This component and its source code representation are copyright protected
 * and proprietary to Trivera Technologies, LLC, Worldwide D/B/A Trivera Technologies
 *
 * This component and source code may be used for instructional and
 * evaluation purposes only. No part of this component or its source code
 * may be sold, transferred, or publicly posted, nor may it be used in a
 * commercial or production environment, without the express written consent
 * of Trivera Technologies, LLC
 *
 * Copyright (c) 2020 Trivera Technologies, LLC.
 * http://www.triveratech.com  
 * </p>
 * @author Trivera Technologies, LLC.
 */

public class ColorPicker extends JButton{

  /**
   *Constructor builds the button, adds the action listener to the button.
   *Action is to create an instance of the JColorChooser and do dialog.
   *Once color is selected, background is turned to new color.
   **/
  public ColorPicker() {
    setText("Show ColorPicker");
    addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        Color c;
        c = JColorChooser.showDialog(((Component)e.getSource()).getParent(),
                                                 "Color Selector", Color.blue);
        setBackground(c);
      }
    });
  }

  /**
   *Invoked when this class is called form command line.
   **/
  public static void main(String[] args) {
    //Create the main window for application
    JFrame mainWindow = new JFrame("Color Selection Demo");
    mainWindow.setSize(200,100);
    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Create the color selector button and add to main window.
    ColorPicker cp = new ColorPicker();
    mainWindow.getContentPane().add(cp);

    //Set the main window in middle of screen
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension m = mainWindow.getSize();
    d.width -= m.width;
    d.height -= m.height;
    d.width /= 2;
    d.height /= 2;
    mainWindow.setLocation(d.width, d.height);
    mainWindow.setVisible(true);

  }
}
