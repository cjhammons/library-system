package com.kraken.UserInterface;

import com.kraken.Database.DatabaseManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Jessica on 12/6/16.
 */
public class ValidateMember {
    private JPanel login_panel;
    private JTextField memberIDTextField;
    private JPasswordField passwordPasswordField;
    private JTextField inputInvalidPleaseTryTextField;
    private JButton logInButton;
    private JLabel invalid_label;
    public static final Dimension WINDOW_DIMENSION = new Dimension(500,500);

    public ValidateMember() {
        invalid_label.setVisible(false);
        //inputInvalidPleaseTryTextField.setText("Invalid Input: Please Try Again");
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

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkValidate();
            }
        });
    }

    public void checkValidate(){
        boolean isValid = false;

        int id = Integer.parseInt(memberIDTextField.getText());
        DatabaseManager databaseManager = new DatabaseManager();

        char[] input = passwordPasswordField.getPassword();
        String inputPassword = new String(input);
        isValid = databaseManager.validateMember(id, inputPassword);
        if(!isValid){
            invalid_label.setVisible(true);
        }


        else {
            invalid_label.setVisible(false);
            JFrame frame = new JFrame("start screen");
            frame.setContentPane(new WelcomeScreen().getWelcome_panel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setPreferredSize(WINDOW_DIMENSION);

            frame.pack();
            frame.setVisible(true);
        }
    }
    public JPanel getLogin_panel(){
        return login_panel;
    }
}
