package com.kraken.UserInterface;

import com.kraken.DataStructures.Members.Member;

import javax.swing.*;

/**
 * Created by Jessica on 12/5/16.
 */
public class addMember {
    private JTextField nameTextField;
    private JComboBox<String> comboBox1;
    private JTextField passwordTextField;
    private JPanel add_member_panel;

    public Member createNewObject() {
        comboBox1.insertItemAt("Librarian", 1);
        comboBox1.insertItemAt("Patron", 2);
        Member newMember = new Member();
        newMember.setName(nameTextField.getText());
        newMember.setPassword(passwordTextField.getText());
        if (comboBox1.getSelectedItem().equals("Librarian")) {
            newMember.setLibrarian(true);
        }
        newMember.setCanCheckOut(true);
        return newMember;
    };

    public JPanel getAdd_member_panel() {
        return add_member_panel;
    }
}