package com.kraken;

import com.kraken.DataStructures.Items.Books.Enumerations.Status;
import com.kraken.DataStructures.Items.Books.Enumerations.Type;
import com.kraken.DataStructures.Items.Books.HardCopy;
import com.kraken.Database.DatabaseManager;
import com.kraken.UserInterface.StartScreen;

import javax.swing.*;
import java.sql.SQLException;

/**
 * Created by Curtis on 11/15/2016.
 *
 * Driver class with the main method
 */
public class main {
    public static void main(String[] args) {

        DatabaseManager databaseManager = null;
        try {
            databaseManager = new DatabaseManager();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        boolean created = databaseManager.initializeTables();
        //create test item
        HardCopy book = new HardCopy();
        book.setCost(13232);
        book.setGenre("Fiction");
        book.setTitle("Of Mice and Men");
        book.setStatus(Status.InLibrary);
        book.setType(Type.HardCopy);
        book.setAuthor("John Steinbeck");
        book.setISBN(38278504);
        book.setLocationInLibrary("over there");
        boolean added = databaseManager.addItem(book);

        JFrame frame = new JFrame("start screen");
        frame.setContentPane(new StartScreen().getMain_panel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.pack();
        frame.setVisible(true);
    }

}
