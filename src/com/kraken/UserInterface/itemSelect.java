package com.kraken.UserInterface;

import com.kraken.DataStructures.Items.Books.Enumerations.Type;
import com.kraken.DataStructures.Items.DiscItems.CD;
import com.kraken.main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Curtis on 12/6/2016.
 */
public class itemSelect {
    private JPanel item_select_panel;
    private JComboBox itemBox;
    private JTextArea title;
    private JButton okButton;

    public itemSelect() {
//        itemBox.insertItemAt("Hard Copy Book", 1);
//        itemBox.insertItemAt("eBook", 2);
//        itemBox.insertItemAt("Audio Book", 3);
//        itemBox.insertItemAt("DVD", 4);
//        itemBox.insertItemAt("CD", 5);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Type type = null;
                switch (itemBox.getSelectedIndex()) {
                    case 0:
                        type = Type.HardCopy;
                        break;
                    case 1:
                        type=Type.eBook;
                        break;
                    case 2:
                        type = Type.AudioBook;
                        break;
                    case 3:
                        type = Type.DVD;
                        break;
                    case 4:
                    default:
                        type = Type.CD;
                        break;
                }

                JFrame frame = new JFrame("Add Item");
                frame.setContentPane(new addItem(type).getAdd_item_panel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(main.WINDOW_DIMENSION);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public JPanel getItem_select_panel() {
        return item_select_panel;
    }
}
