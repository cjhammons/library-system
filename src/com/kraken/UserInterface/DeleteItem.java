package com.kraken.UserInterface;

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
public class DeleteItem {

    private JTextField itemIDField;
    private JTextField workedText;
    private JButton deleteButton;
    private JButton backButton;
    private JPanel delete_panel;

    public DeleteItem(){
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

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete();
            }
        });

    }

    void delete(){
        int id = Integer.parseInt(itemIDField.getText());
        boolean success = new DatabaseManager().deleteItem(id);
        if (success){
            workedText.setText(id + " deleted");
        } else {
            workedText.setText(id + " not deleted");
        }
        new DatabaseManager().printItemTable();
    }

    public JPanel getDelete_panel() {
        return delete_panel;
    }
}
