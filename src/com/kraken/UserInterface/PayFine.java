package com.kraken.UserInterface;

import com.kraken.Database.DatabaseManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.kraken.main.WINDOW_DIMENSION;

/**
 * Created by Curtis on 12/6/2016.
 */
public class PayFine {
    private JPanel payFinePanel;
    private JButton backButton;
    private JButton payButton;
    private JTextField memberIDTextField;
    private JTextField resultTxtTextField;
    private JTextField amountPaidTextField;

    public PayFine() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("start screen");
                frame.setContentPane(new MemberTransaction().getMembertransactionsPanel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(WINDOW_DIMENSION);
                frame.pack();
                frame.setVisible(true);
            }
        });

        memberIDTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                memberIDTextField.setText("");
            }
        });

        amountPaidTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                amountPaidTextField.setText("");
            }
        });

        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pay();
            }
        });
    }

    void pay(){
        int id = Integer.parseInt(memberIDTextField.getText());
        double amount = Double.parseDouble(amountPaidTextField.getText());
        DatabaseManager databaseManager = new DatabaseManager();
        boolean success = databaseManager.payFine(id, amount);

        if (success) {
            resultTxtTextField.setText(id + " Fines payed successfully.");
        } else {
            resultTxtTextField.setText(id + " Fines not paid");
        }
    }

    public JPanel getPayFinePanel() {
        return payFinePanel;
    }
}
