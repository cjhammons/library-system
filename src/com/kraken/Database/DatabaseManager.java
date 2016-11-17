package com.kraken.Database;

import com.kraken.DataStructures.Items.Item;

import java.lang.reflect.Member;
import java.sql.*;

/**
 * Created by Curtis on 11/16/2016.
 */
public class DatabaseManager {

    Connection connection;

    public DatabaseManager() throws SQLException {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:library.db");
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * Builds the database if it doesn't exist.
     * @return true if success, false if not
     */
    public boolean initialize(){
        try {
            Class.forName("org.sqlite.JDBC");
            createItemTable();
            createMemberTable();
        } catch (Exception e) {
            System.out.println("Database error: " + e.getClass().getName() + ": " +e.getMessage());
            return false;
        }
        return true;
    }

    /*
    * ----------------------------------------------------------------------------------------------------------
    *                                               Member Methods
    * ----------------------------------------------------------------------------------------------------------
    */

    public boolean deleteMember(Member member) {
        return true;
    }

    public boolean addMember(Member member) {
        return true;
    }

    /*
    * ----------------------------------------------------------------------------------------------------------
    *                                               Item Methods
    * ----------------------------------------------------------------------------------------------------------
    */

    public boolean addItem(Item item){
        return true;
    }

    public boolean deleteItem(Item item) {
        return true;
    }

    public boolean checkOut(Item item) {
        return true;
    }

    public boolean checkIn(Item item) {
        return true;
    }

    public boolean renewItem(Item item) {
        return true;
    }

    public boolean payFine(Item item){
        return true;
    }

    /*
    * ----------------------------------------------------------------------------------------------------------
    *                                               Other stuff
    * ----------------------------------------------------------------------------------------------------------
    */

    private boolean createItemTable(){
        try {
            Class.forName("org.sqlite.JDBC");
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS itemTable "
                            + "(ID INTEGER PRIMARY KEY UNIQUE NOT NULL, "
                            + "cost         INTEGER, "
                            + "genre        TEXT, "
                            + "title        TEXT, "
                            + "status       TEXT, "
                            + "type_        TEXT, "
                            + "author       TEXT, "     //books & audiobooks only
                            + "isbn         INTEGER, "  //books & audiobooks only
                            + "accessPnt    TEXT, "     //ebooks only
                            + "location     TEXT, "     //hardcopys only);
                            + "numDiscs     INTEGER, "  //DiscItems only
                            + "runTime      TEXT, "     //DiscItems only
                            + "artist       TEXT, "     //CD only
                            + "director     TEXT, "     //DVD only
                            + "mainActor    TEXT"       //DVD only
                            + ")"
            );
            stmt.close();
        } catch (Exception e) {
            System.out.println("Item Table error: " + e.getClass().getName() + ": " +e.getMessage());
            return false;
        }
        return true;
    }

    private boolean createMemberTable() {
        try {
            Class.forName("org.sqlite.JDBC");
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS memberTable "
                    + "(ID INTEGER PRIMARY KEY UNIQUE NOT NULL, "
                    + "name                 TEXT, "
                    + "fines                DOUBLE PRECISION, "
                    + "canCheckout          BOOLEAN, "
                    + "isLibrarian          BOOLEAN"
                    + ")"
            );
            stmt.close();
        } catch (Exception e) {
            System.out.println("Member Table error: " + e.getClass().getName() + ": " +e.getMessage());
            return false;
        }
        return true;
    }


}
