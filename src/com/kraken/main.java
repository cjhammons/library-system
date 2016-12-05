package com.kraken;

import com.kraken.DataStructures.Items.Books.Enumerations.Status;
import com.kraken.DataStructures.Items.Books.Enumerations.Type;
import com.kraken.DataStructures.Items.Books.HardCopy;
import com.kraken.DataStructures.Items.Item;
import com.kraken.DataStructures.Members.Member;
import com.kraken.Database.DatabaseManager;
import com.kraken.UserInterface.StartScreen;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.util.List;

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
            System.out.println("Database didn't initialize");
        }
        /* WHO NEEDS UNIT TESTS ANYWAY*/

        //create test item
//        testAddPlsIgnore(databaseManager);
//        testDeletePlsIgnore(databaseManager);
//        getAllTest(databaseManager);
        testAddMember(databaseManager);


        JFrame frame = new JFrame("start screen");
        frame.setContentPane(new StartScreen().getMain_panel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.pack();
        frame.setVisible(true);
    }


    /* --------------------------------------------------------------
    *           make sure all these get deleted before submit. //TODO
    *  --------------------------------------------------------------
    */
    static void testAddMember(DatabaseManager databaseManager) {
        Member member = new Member();
        member.setName("Billy Bob Bobkins");
        member.setFines(3.14);
        member.setCanCheckOut(true);
        member.setLibrarian(true);
        databaseManager.addMember(member);
        databaseManager.printMemberTable();
    }
    static void getAllTest(DatabaseManager databaseManager) {
        List<Item> list = databaseManager.getAllItems();
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
            System.out.println("Item didn't add for some reason");
        }
    }

    static void testDeletePlsIgnore(DatabaseManager databaseManager) {
        HardCopy book = new HardCopy();
        book.setItemID(8);
        if (databaseManager.deleteItem(book)) {
            databaseManager.printItemTable();
        } else {
            System.out.println("Item wasn't deleted :(");
        }
    }

}
