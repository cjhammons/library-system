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
public class CheckMemberStatus {
    private JPanel checkStatusPanel;
    private JTextField memberIDField;
    private JTextField workedText;
    private JButton checkButton;
    private JButton backButton;


    public CheckMemberStatus() {
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

        memberIDField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                memberIDField.setText("");
            }
        });

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check();
            }
        });
    }

    void check(){
        int id = Integer.parseInt(memberIDField.getText());
        DatabaseManager databaseManager = new DatabaseManager();

        boolean canCheckout = databaseManager.checkMemberStatus(id);

        if (canCheckout){
            workedText.setText(id + " can check out");
        } else {
            workedText.setText(id + " can't check out");
        }

        databaseManager.printMemberTable();
    }

    public JPanel getCheckStatusPanel() {
        return checkStatusPanel;
    }
}
