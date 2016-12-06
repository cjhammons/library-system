package com.kraken.UserInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.kraken.main.WINDOW_DIMENSION;

/**
 * Created by Curtis on 12/6/2016.
 */
public class MemberTransaction {
    private JTextPane memberTransactionsTextPane;
    private JButton addMemberButton;
    private JButton delteMemberButton;
    private JButton printMemberListButton;
    private JButton checkMemberStatusButton;
    private JButton backButton;
    private JPanel membertransactionsPanel;

    public MemberTransaction(){
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("start screen");
                frame.setContentPane(new WelcomeScreen().getWelcome_panel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(WINDOW_DIMENSION);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }


    public JPanel getMembertransactionsPanel() {
        return membertransactionsPanel;
    }
}
