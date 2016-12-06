package com.kraken.UserInterface;

import com.kraken.DataStructures.Items.Item;
import com.kraken.Database.DatabaseManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/**
 * Created by dbt00_000 on 12/5/2016.
 */
public class DeleteItem {
    private JTextField textField1;
    private JButton deleteItemTypeItemButton;


    DatabaseManager databaseManager = new DatabaseManager();
       // databaseManager.deleteItem(textField1); // trying to access the method in the database, is not working
        //databaseManager.printItemTable(); // same thing





    /*deleteItemTypeItemButton.addMouseListener(new MouseAdapter() ){
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            deleteItemTypeItemButton.setText("");
        }
    });
*/

}

      //  public JPanel getAdd_item_panel() {
            //return add_item_panel;
//}
