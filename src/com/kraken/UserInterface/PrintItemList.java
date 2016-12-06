package com.kraken.UserInterface;

import com.kraken.DataStructures.Items.Item;
import com.kraken.Database.DatabaseManager;

import javax.swing.*;
import java.util.List;

/**
 * Created by Curtis on 12/6/2016.
 */
public class PrintItemList {
    private JList listyMcListFace;
    private JPanel printListPanel;

    public PrintItemList() {
        DatabaseManager databaseManager = new DatabaseManager();
        List<Item> list = databaseManager.getAllItems();
        listyMcListFace.setListData(list.toArray());
    }

    public JPanel getPrintListPanel() {
        return printListPanel;
    }
}
