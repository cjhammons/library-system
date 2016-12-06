package com.kraken.UserInterface;

import com.kraken.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.kraken.main.WINDOW_DIMENSION;

/**
 * Created by Curtis on 11/15/2016.
 */
public class ItemTransaction {
    private JTextField test_text_field;
    private JPanel main_panel;
    private JButton addItemButton;
    private JButton checkoutItemButton;
    private JButton checkinItemButton;
    private JButton renewItemButton;
    private JButton searchCatalogButton;
    private JButton checkItemStatusButton;
    private JButton printItemListButton;
    private JButton deleteItemButton;
    private JButton backButton;

    public ItemTransaction() {
        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Select Item Type");
                frame.setContentPane(new itemSelect().getItem_select_panel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(main.WINDOW_DIMENSION);
                frame.pack();
                frame.setVisible(true);
            }
        });

        searchCatalogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Search Catalog");
                frame.setContentPane(new SearchCatalog().getSearch_panel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(main.WINDOW_DIMENSION);
                frame.pack();
                frame.setVisible(true);
            }
        });

        printItemListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Print List");
                frame.setContentPane(new PrintItemList().getPrintListPanel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(main.WINDOW_DIMENSION);
                frame.pack();
                frame.setVisible(true);
            }
        });

        checkoutItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Print List");
                frame.setContentPane(new CheckoutItem().getCheckout_panel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(main.WINDOW_DIMENSION);
                frame.pack();
                frame.setVisible(true);
            }
        });

        renewItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Print List");
                frame.setContentPane(new RenewItem().getRenewpanel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(main.WINDOW_DIMENSION);
                frame.pack();
                frame.setVisible(true);
            }
        });

        checkinItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Print List");
                frame.setContentPane(new CheckInItem().getChedkInPanel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(main.WINDOW_DIMENSION);
                frame.pack();
                frame.setVisible(true);
            }
        });

        checkItemStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Print List");
                frame.setContentPane(new CheckItemStatus().getItemStatusPanel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(main.WINDOW_DIMENSION);
                frame.pack();
                frame.setVisible(true);
            }
        });

        deleteItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Print List");
                frame.setContentPane(new DeleteItem().getDelete_panel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(main.WINDOW_DIMENSION);
                frame.pack();
                frame.setVisible(true);
            }
        });

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

    public JPanel getMain_panel() {
        return main_panel;
    }
}
