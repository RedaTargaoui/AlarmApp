/**
 * @file AlarmApp.java
 * @brief Creating a simple alarm app
 * @author Reda TARGAOUI
 * @version 1.0
 * @date 04/25/2023
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;

public class Alarm extends JFrame {
    // Attributes :
    private JTextField hoursField;// Input hours field
    private JTextField minutesField;// Input minutes field
    private JTextField secondsField;// Input seconds field
    private JButton setButton; // Set alarm button
    private JButton cancelButton; // Cancel alarm button
    private Timer timer; // The timer

    // Constructor & destructor :
    /**
     * @fn AlarmApp()
     * @brief Initialise the components
     */
    public Alarm() {
        setTitle("Alarm App");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        // Initialising attributes :
        hoursField = new JTextField(2);
        minutesField = new JTextField(2);
        secondsField = new JTextField(2);
        setButton = new JButton("Set Alarm");
        cancelButton = new JButton("Cancel Alarm");

        // Edit buttons style :
        // Set alarm button :
        setButton.setFont(new Font("Arial", Font.ITALIC, 15));
        setButton.setForeground(Color.WHITE);
        setButton.setBackground(Color.BLACK);
        setButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setButton.setPreferredSize(new Dimension(120, 40));

        // Cancel alarm button :
        cancelButton.setFont(new Font("Arial", Font.ITALIC, 15));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cancelButton.setPreferredSize(new Dimension(120, 40));

        // Input time fields panel :
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Hours : "));
        inputPanel.add(hoursField);
        inputPanel.add(new JLabel("Minutes : "));
        inputPanel.add(minutesField);
        inputPanel.add(new JLabel("Seconds : "));
        inputPanel.add(secondsField);

        // Set and Cancel buttons panel :
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(setButton);
        buttonsPanel.add(cancelButton);

        // Adding panels to window :
        add(inputPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);

        // Add an action listener for the set alarm button :
        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int hours = Integer.parseInt(hoursField.getText());
                    int minutes = Integer.parseInt(minutesField.getText());
                    int seconds = Integer.parseInt(secondsField.getText());
                    setAlarm(timeToSeconds(hours, minutes, seconds));
                }
                catch (NumberFormatException EXCObject) {
                    JOptionPane.showMessageDialog(null, "Inputs must be numbers!!");
                }
            }
        });

        // Add an action listener for the cancel alarm button :
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelAlarm();
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * @fn setAlarm()
     * @brief Sets the alarm
     * @param seconds number of seconds
     */
    private void setAlarm(int seconds) {
        timer = new Timer();
        // Set the timer :
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Alarm went off!");
            }
        }, seconds * 1000L);
    }

    /**
     * @fn cancelAlarm
     * @brief Cancels the alarm
     */
    private void cancelAlarm() {
        if ( timer != null ) {
            timer.cancel();
        }
    }

    /**
     * @fn timeToSeconds()
     * @brief Convert the time entered by user to seconds
     * @param hours hours entered by user
     * @param minutes minutes entered by user
     * @param seconds seconds entered by user
     * @return int seconds
     */
    private int timeToSeconds(int hours, int minutes, int seconds) {
        return (hours * 3600) + (minutes * 60) + seconds;
    }

}
