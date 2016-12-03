package com.kraken;

import com.kraken.DataStructures.Items.Books.Enumerations.Status;
import com.kraken.DataStructures.Items.Books.Enumerations.Type;
import com.kraken.DataStructures.Items.Books.HardCopy;
import com.kraken.Database.DatabaseManager;
import com.kraken.UserInterface.StartScreen;

import javax.swing.*;

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
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean created = databaseManager.initializeTables();
        if (!created) {
            System.out.println("Database didn't initialize! :( :( :( :( :( :(");
        }
        //create test item
        testAddPlsIgnore(databaseManager);
        testDeletePlsIgnore(databaseManager);
        JFrame frame = new JFrame("start screen");
        frame.setContentPane(new StartScreen().getMain_panel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.pack();
        frame.setVisible(true);
    }
    
    
    static void testAddPlsIgnore(DatabaseManager databaseManager) {
        HardCopy book = new HardCopy();
        book.setCost(13232);
        book.setGenre("Fiction");
        book.setTitle("The great book of memes");
        book.setStatus(Status.InLibrary);
        book.setType(Type.HardCopy);
        book.setAuthor("Curtis Hammons");
        book.setISBN(38278504);
        book.setLocationInLibrary("over_there");
        boolean added = databaseManager.addItem(book);
        if (added) {
            databaseManager.printItemTable();
        } else {
            System.out.println("Item didn't add for some godamn reason");
        }
    }

    static void testDeletePlsIgnore(DatabaseManager databaseManager) {
        /* why? */
        HardCopy book = new HardCopy();
        book.setItemID(8);
        if (databaseManager.deleteItem(book)) {
            databaseManager.printItemTable();
        } else {
            System.out.println("Item wasn't deleted :(");
        }
    }

}
