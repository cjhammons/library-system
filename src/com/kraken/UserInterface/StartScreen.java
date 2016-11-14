package com.kraken.UserInterface.UserInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Curtis on 11/14/2016.
 *
 * This is the main screen that will be displayed on app start.
 */
public class StartScreen  {

    private JTextField main_text_field;
    private JPanel panel_Main;
    private JButton test_Button;


    public StartScreen() {

        test_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Krakens and Krakens and Krakens and Krakens");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("StartScreen");
        frame.setContentPane(new StartScreen().panel_Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100, 100);
        frame.pack();
        frame.setVisible(true);
    }
}
