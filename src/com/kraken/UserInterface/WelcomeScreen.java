package com.kraken.UserInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.kraken.main.WINDOW_DIMENSION;

/**
 * Created by Curtis on 12/6/2016.
 */
public class WelcomeScreen {
    private JPanel welcome_panel;
    private JTextField welcomeToTheLibraryTextField;
    private JButton itemTransactionsButton;
    private JButton memberTransactionsButton;

    public WelcomeScreen() {
        itemTransactionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Item Screen");
                frame.setContentPane(new ItemTransaction().getMain_panel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(WINDOW_DIMENSION);

                frame.pack();
                frame.setVisible(true);
            }
        });

        memberTransactionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Item Screen");
                frame.setContentPane(new MemberTransaction().getMembertransactionsPanel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(WINDOW_DIMENSION);

                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public JPanel getWelcome_panel() {
        return welcome_panel;
    }
}
