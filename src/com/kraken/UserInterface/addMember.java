package com.kraken.UserInterface;

import com.kraken.DataStructures.Members.Member;
import com.kraken.Database.DatabaseManager;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.kraken.main.WINDOW_DIMENSION;

/**
 * Created by Jessica on 12/5/16.
 */
public class addMember {
    private JTextField nameTextField;
    private JComboBox<String> comboBox1;
    private JTextField passwordTextField;
    private JPanel add_member_panel;
    private JButton createMemberButton;
    private JButton backButton;

    public addMember() {
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

        createMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMember();
            }
        });

        nameTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                nameTextField.setText("");
            }
        });

        passwordTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                passwordTextField.setText("");
            }
        });
    }

    public void addMember() {
        comboBox1.insertItemAt("Librarian", 1);
        comboBox1.insertItemAt("Patron", 2);
        Member newMember = new Member();
        newMember.setName(nameTextField.getText());
        newMember.setPassword(passwordTextField.getText());
        if (comboBox1.getSelectedIndex() == 1) {
            newMember.setLibrarian(true);
        } else {
            newMember.setLibrarian(false);
        }
        newMember.setCanCheckOut(true);

        DatabaseManager databaseManager = new DatabaseManager();
        int newId = databaseManager.addMember(newMember);
        if (newId > -1){
            System.out.println("Member added. Your ID is: " + newId);
        } else {
            System.out.println("Member not added.");
        }

        databaseManager.printMemberTable();
    }

    public JPanel getAdd_member_panel() {
        return add_member_panel;
    }
}