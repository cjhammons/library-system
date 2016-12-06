package com.kraken.UserInterface;

import com.kraken.DataStructures.Items.Item;
import com.kraken.Database.DatabaseManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * Created by Curtis on 12/6/2016.
 */
public class SearchCatalog {
    private JPanel search_panel;
    private JList itemList;
    private JTextArea searchBox;
    private JButton searchButton;


    public SearchCatalog() {
        searchBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                searchBox.setText("");
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search();
            }
        });
    }

    void search() {
        DatabaseManager databaseManager = new DatabaseManager();
        String param = searchBox.getText();
        List<Item> list = databaseManager.searchItem(param);
//        Vector<Item> vector = new Vector<>(list.size());
//        Collections.copy(vector, list);
        itemList.setListData(list.toArray());

    }

    public JPanel getSearch_panel() {
        return search_panel;
    }
}
