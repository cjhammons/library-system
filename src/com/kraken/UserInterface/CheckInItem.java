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
public class CheckInItem {
    private JTextField workedText;
    private JTextField itemIDField;
    private JButton checkInButton;
    private JButton backButton;
    private JPanel chedkInPanel;

    public CheckInItem(){
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

        itemIDField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                itemIDField.setText("");
            }
        });

        checkInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkIn();
            }
        });

        workedText.setVisible(false);
    }

    void checkIn() {
        int id = Integer.parseInt(itemIDField.getText());
        boolean success = new DatabaseManager().checkIn(id);
        if (success){
            workedText.setText(id + " checked in");
        } else {
            workedText.setText(id + " not checked in :(");

        }
        workedText.setVisible(true);
        new DatabaseManager().printItemTable();
    }

    public JPanel getChedkInPanel() {
        return chedkInPanel;
    }
}
