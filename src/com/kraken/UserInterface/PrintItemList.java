package com.kraken.UserInterface;

import com.kraken.DataStructures.Items.Item;
import com.kraken.Database.DatabaseManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static com.kraken.main.WINDOW_DIMENSION;

/**
 * Created by Curtis on 12/6/2016.
 */
public class PrintItemList {
    private JList listyMcListFace;
    private JPanel printListPanel;
    private JButton backButton;

    public PrintItemList() {
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
        DatabaseManager databaseManager = new DatabaseManager();
        List<Item> list = databaseManager.getAllItems();
        listyMcListFace.setListData(list.toArray());
    }

    public JPanel getPrintListPanel() {
        return printListPanel;
    }
}
