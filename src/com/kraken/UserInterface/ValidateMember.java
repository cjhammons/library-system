package com.kraken.UserInterface;

import com.kraken.Database.DatabaseManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Jessica on 12/6/16.
 */
public class ValidateMember {
    private JTextField memberIDTextField;
    private JPasswordField passwordPasswordField;
    private JTextField inputInvalidPleaseTryTextField;
    public static final Dimension WINDOW_DIMENSION = new Dimension(500,500);

    public void validateMemberForm() {
        boolean isValid = false;
        inputInvalidPleaseTryTextField.setVisible(false);

        memberIDTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                memberIDTextField.setText("");
            }
        });
        passwordPasswordField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                passwordPasswordField.setText("");
            }
        });

        while(!isValid) {
            int id = Integer.parseInt(memberIDTextField.getText());
            DatabaseManager databaseManager = new DatabaseManager();

            char[] input = passwordPasswordField.getPassword();
            String inputPassword = new String(input);
            isValid = databaseManager.validateMember(id, inputPassword);
            if(!isValid){
                inputInvalidPleaseTryTextField.setVisible(true);
            }
        }

        JFrame frame = new JFrame("start screen");
        frame.setContentPane(new WelcomeScreen().getWelcome_panel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(WINDOW_DIMENSION);

        frame.pack();
        frame.setVisible(true);

    }
}
