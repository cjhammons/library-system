package com.kraken.UserInterface;

import com.kraken.DataStructures.Items.Books.HardCopy;
import com.kraken.DataStructures.Items.Item;
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
public class CheckoutItem {
    private JButton backButton;
    private JPanel checkout_panel;
    private JTextField itemIDField;
    private JButton checkOutButton;
    private JTextPane workedText;

    public CheckoutItem() {
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

        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkout();
            }
        });

        workedText.setVisible(false);
    }

    void checkout(){
        int id = Integer.parseInt(itemIDField.getText());
        boolean success = new DatabaseManager().checkOut(id);
        if (success){
            workedText.setText(id + " checked out");
        } else {
            workedText.setText(id + " not checked out :(");

        }
        workedText.setVisible(true);
        new DatabaseManager().printItemTable();
    }

    public JPanel getCheckout_panel() {
        return checkout_panel;
    }
}
