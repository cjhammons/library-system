package com.kraken;

import com.kraken.UserInterface.StartScreen;

import javax.swing.*;

/**
 * Created by Curtis on 11/15/2016.
 *
 * Driver class with the main method
 */
public class main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("start screen");
        frame.setContentPane(new StartScreen().getMain_panel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.pack();
        frame.setVisible(true);
    }
}
