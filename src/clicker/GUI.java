/**
 * Copyright (C) 2012 Sogima
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program. If not, see <http://www.gnu.org/licenses/>
 */

package clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 * Class that provide a grafic interface for the user.
 * It allow to click a fixed amount of time, or to click for a
 * fixed amount of time, repeatedly in both cases.
 * There are two different buttons and textbox for each "type of clicking".
 * Only one of the two can be executed per time.
 */
public class GUI extends javax.swing.JFrame
{
    /** Clicker object that uses a robot */
    private Clicker c;
    /** Timer used to activate the clicker */
    private Timer timer;

    /** Creates new form GUI */
    public GUI()
    {
        initComponents();
        c = new Clicker();

        // add listeners for both operations provided
        NumClickButton.addActionListener(new NumClickListener());
        TimeClickButton.addActionListener(new TimeClickListener());

        this.setResizable(false);
        this.setTitle("Clicker");
    }

    /**
     * Code generated from the IDE to initialize all grafical elements (initial
     * value and position of each one)
     */
    private void initComponents()
    {
        // instantiate all objects
        jPanel1 = new javax.swing.JPanel();
        NumClicks = new javax.swing.JLabel();
        NumClickButton = new javax.swing.JButton();
        NumClickField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TimeClickField = new javax.swing.JTextField();
        TimeClickButton = new javax.swing.JButton();
        CountdownField = new javax.swing.JTextField();

        // initialize values
        NumClicks.setLabelFor(NumClickField);
        NumClicks.setText("Number of clicks:");
        NumClicks.setNextFocusableComponent(NumClickField);

        NumClickButton.setText("Start");
        NumClickButton.setNextFocusableComponent(jLabel2);

        NumClickField.setText("0");
        NumClickField.setNextFocusableComponent(NumClickButton);

        jLabel2.setText("Time for clicks:");
        jLabel2.setNextFocusableComponent(TimeClickField);

        TimeClickField.setText("0");
        TimeClickField.setNextFocusableComponent(TimeClickButton);

        TimeClickButton.setText("Start");
        TimeClickButton.setNextFocusableComponent(NumClicks);

        // se position of each element
        CountdownField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        CountdownField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        CountdownField.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(CountdownField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NumClickField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NumClicks)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(NumClickButton)))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(TimeClickButton))
                            .addComponent(TimeClickField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TimeClickField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TimeClickButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(NumClickField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NumClickButton))
                    .addComponent(NumClicks))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CountdownField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        NumClicks.getAccessibleContext().setAccessibleName("NumClicks");
        NumClickButton.getAccessibleContext().setAccessibleName("NumClickButton");
        NumClickField.getAccessibleContext().setAccessibleName("NumClickField");
        jLabel2.getAccessibleContext().setAccessibleName("TimeClick");
        TimeClickField.getAccessibleContext().setAccessibleName("TimeClickField");
        TimeClickButton.getAccessibleContext().setAccessibleName("TimeClickButton");
        CountdownField.getAccessibleContext().setAccessibleName("CountdownField");

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        // release resources on close
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        this.setVisible(true);
    }

    /**
     * Main for the invocation from command line
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        GUI g = new GUI();
    }

    /**
     * Listener invoked when NumClickButton is pressed
     */
    class NumClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(timer != null)
                timer.stop();
            timer = new Timer(1000, new countdownListener(CountdownField, 5, 1));
            timer.start();
        }
    }

    /**
     * Listener invoked when TimeClickButton is pressed
     */
    class TimeClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(timer != null)
                timer.stop();
            timer = new Timer(1000, new countdownListener(CountdownField, 5, 2));
            timer.start();
        }
    }

    /**
     * Action listener used to show the countdown in a jTextField
     */
    class countdownListener implements ActionListener
    {
        private JTextField tf;
        private int count, action;

        /**
         * Default constructor used to save used parameters
         * @param tf JTextField to modify
         * @param count Number of times to apply an edit
         */
        public countdownListener(JTextField tf, int count, int action)
        {
            this.tf = tf;
            this.count = count;
            this.action = action;
        }

        /**
         * Differentiate the operation performed when this listener is triggered
         * by an event, that can be a NumClick or TimeClick.
         * @param e Event just happened, that trigger this listener
         */
        public void actionPerformed(ActionEvent e)
        {
            // show a countdown message
            if(count > 0)
            {
                tf.setText("Starting clicking in: " + count + " seconds!");
                count--;
            }
            // execute the correct operation and stop the timer
            else if(count == 0)
            {
                // for the first action
                if(action == 1)
                {
                    int n = Integer.parseInt(NumClickField.getText());
                    c.ClickByNum(n);
                }
                // for the second action
                if(action == 2)
                {
                    int n = Integer.parseInt(TimeClickField.getText());
                    c.ClickByTime(n);
                }
                tf.setText("Go!");
                timer.stop();
            }
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JTextField CountdownField;
    private javax.swing.JButton NumClickButton;
    private javax.swing.JTextField NumClickField;
    private javax.swing.JLabel NumClicks;
    private javax.swing.JButton TimeClickButton;
    private javax.swing.JTextField TimeClickField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration
}
