package com.kraken.UserInterface;

import com.kraken.DataStructures.Items.Books.Enumerations.Status;
import com.kraken.Database.DatabaseManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.kraken.main.WINDOW_DIMENSION;

/**
 * Created by Curtis on 12/6/2016.
 */
public class CheckItemStatus {
    private JPanel itemStatusPanel;
    private JTextField itemIdField;
    private JButton checkStatusButton;
    private JButton backButton;
    private JTextField statusDisplay;

    public CheckItemStatus() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("start screen");
                frame.setContentPane(new ItemTransaction().getMain_panel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(WINDOW_DIMENSION);
                frame.pack();
                frame.setVisible(true);
            }
        });

//        statusDisplay.setVisible(false);

        checkStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkStatus();
            }
        });
    }

    void checkStatus() {
        int id = Integer.parseInt(itemIdField.getText());
        Status status = new DatabaseManager().getItemStatus(id);
        statusDisplay.setVisible(true);
        statusDisplay.setText("Status of " + id + ": " + status.toString());

        new DatabaseManager().printItemTable();
    }

    public JPanel getItemStatusPanel() {
        return itemStatusPanel;
    }
}
