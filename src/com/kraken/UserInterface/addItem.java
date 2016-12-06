package com.kraken.UserInterface;

import com.kraken.DataStructures.Items.Books.Book;
import com.kraken.DataStructures.Items.Books.EBook;
import com.kraken.DataStructures.Items.Books.HardCopy;
import com.kraken.DataStructures.Items.DiscItems.AudioBook;
import com.kraken.DataStructures.Items.DiscItems.CD;
import com.kraken.DataStructures.Items.DiscItems.DVD;
import com.kraken.DataStructures.Items.Item;

import javax.swing.*;

/**
 * Created by Jessica on 12/5/16.
 */
public class addItem {
    private JTextField itemTitleTextField;
    private JTextField itemIDTextField;
    private JComboBox comboBox1;
    private JTextField ADDHERETextField;
    private JTextField hardCopyTextField;

    public void setVisibilities() {
        hardCopyTextField.setVisible(false);

    }

    public Item createNewItem(){
        comboBox1.insertItemAt("Hard Copy Book", 1);
        comboBox1.insertItemAt("eBook", 2);
        comboBox1.insertItemAt("Audio Book", 3);
        comboBox1.insertItemAt("DVD", 4);
        comboBox1.insertItemAt("CD", 5);

        int index = comboBox1.getSelectedIndex();
        Item newItem;
        switch(index) {
            case 1:
                newItem = new HardCopy();
                hardCopyTextField.setVisible(true);
                break;
            case 2:
                newItem = new EBook();
                break;
            case 3:
                newItem = new AudioBook();
                break;
            case 4:
                newItem = new DVD();
                break;
            case 5:
                newItem = new CD();
                break;
            default:
                System.out.print("Invalid item type selected.");
                return newItem;
        }

        newItem.setTitle(itemTitleTextField.getText());
        int id = itemIDTextField.getText(); //THIS NEEDS TO BE CONVERTED
        newItem.setItemID();




    }
}
