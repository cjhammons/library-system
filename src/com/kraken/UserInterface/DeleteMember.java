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
public class DeleteMember {
    private JTextField memberIDField;
    private JPanel deletePanel;
    private JTextField workedText;
    private JButton deleteButton;
    private JButton backButton;

    public DeleteMember(){
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

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete();
            }
        });

        memberIDField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                memberIDField.setText("");
            }
        });
    }

    void delete(){
        int id = Integer.parseInt(memberIDField.getText());
        boolean success= new DatabaseManager().deleteMember(id);
        if (success) {workedText.setText(id + " deleted successfully"); }
        else { workedText.setText(id + " Not deleted successfully"); }

        new DatabaseManager().printMemberTable();
    }


    public JPanel getDeletePanel() {
        return deletePanel;
    }
}
