package com.kraken.Database;

import com.kraken.DataStructures.Items.Books.Book;
import com.kraken.DataStructures.Items.Books.EBook;
import com.kraken.DataStructures.Items.Books.HardCopy;
import com.kraken.DataStructures.Items.DiscItems.AudioBook;
import com.kraken.DataStructures.Items.DiscItems.CD;
import com.kraken.DataStructures.Items.DiscItems.DVD;
import com.kraken.DataStructures.Items.DiscItems.DiscItem;
import com.kraken.DataStructures.Items.Item;

import java.lang.reflect.Member;
import java.sql.*;

/**
 * Created by Curtis on 11/16/2016.
 */
public class DatabaseManager {

//    Connection connection;
    static final String ITEM_TABLE = "itemTable";
    static final String MEMBER_TABLE = "memberTableName";
    static final String DATABASE_NAME = "jdbc:sqlite:library.db";

    public DatabaseManager() throws SQLException {
//        try {
//            connection = DriverManager.getConnection(DATABASE_NAME);
//        } catch (SQLException e) {
//            System.out.println("Database error: " + e.getClass().getName() + ": " +e.getMessage());
//            throw e;
//        }
    }

    /**
     * Builds the Tables if it doesn't exist.
     * @return true if success, false if not
     */
    public boolean initializeTables(){
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

    public boolean updateMemter(Member member) { return true; }

    public void printMemberTable() {};

    /*
    * ----------------------------------------------------------------------------------------------------------
    *                                               Item Methods
    * ----------------------------------------------------------------------------------------------------------
    */

    public boolean addItem(Item item){
        try {
            Connection connection = getDatConnection();
            Statement stmt = connection.createStatement();
            //Create a field an values string and put them together later.
            String fields = "(cost,genre,title,status,type_,";
            String values = "VALUES (" + item.getCost() + ",'" + item.getGenre() + "'," + item.getTitle() + "','" + item.getStatus() + "','" + item.getType() +"'";
            //Adjust fields and values depending on what kind of item this is.
            if (item instanceof Book) {
                fields += "author,isbn,";
                values += ",'" + ((Book) item).getAuthor() + "'," + ((Book) item).getISBN();
                if (item instanceof EBook) {
                    fields += "accessPnt";
                    values += ",'" + ((EBook) item).getAccessPoint() + "'";
                } else if (item instanceof HardCopy) {
                    fields += "location";
                    values += "," + ((HardCopy) item).getLocationInLibrary();
                }
            } if (item instanceof DiscItem) {
                fields += "numDiscs,runTime,";
                values += "," +((DiscItem) item).getNumDiscs() + ",'" + ((DiscItem) item).getRuntime() + "'";
                if (item instanceof AudioBook) {
                    fields += "author,isbn";
                    values += ",'" + ((AudioBook) item).getAuthor() + "'," + ((AudioBook) item).getISBN();
                } else if (item instanceof CD) {
                    fields += "artist";
                    values += ",'" + ((CD) item).getArtist() + "'";
                } else if (item instanceof DVD) {
                    fields += "director,mainActor";
                    values += ",'" + ((DVD) item).getDirector() + "','" + ((DVD) item).getMainActor() + "'";
                }
            }
            fields += ") ";
            values += " );";
            String sql = "INSERT INTO " + ITEM_TABLE + " " + fields + values;
            stmt.executeUpdate(sql);
            stmt.close();
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Item add failed.");
            return false;
        }
        return true;
    }

    public boolean deleteItem(Item item) {
        try {
            Connection connection = getDatConnection();
            Statement stmt = connection.createStatement();
            String sql = "DELETE from " + ITEM_TABLE + " where ID=" + item.getItemID();
            stmt.executeUpdate(sql);
            stmt.close();
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Delete Item failed.");
            printItemTable();
            return false;
        }
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

    public boolean updateItem(Item item) {return true;}

    public void printItemTable() {

    }

    /*
    * ----------------------------------------------------------------------------------------------------------
    *                                               Other stuff
    * ----------------------------------------------------------------------------------------------------------
    */

    private boolean createItemTable(){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = getDatConnection();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS " + ITEM_TABLE + " "
                            + "(ID          INTEGER PRIMARY KEY UNIQUE NOT NULL, "
                            + "cost         INTEGER, "
                            + "genre        TEXT, "
                            + "title        TEXT, "
                            + "status       TEXT, "
                            + "type_        TEXT, "
                            + "author       TEXT, "     //books & audiobooks only
                            + "isbn         INTEGER, "  //books & audiobooks only
                            + "accessPnt    TEXT, "     //ebooks only
                            + "location     TEXT, "     //hardcopys only
                            + "numDiscs     INTEGER, "  //DiscItems only
                            + "runTime      TEXT, "     //DiscItems only
                            + "author       TEXT,"      //Audiobook Only
                            + "isbn         INTEGER,"   //Audiobook Only
                            + "artist       TEXT, "     //CD only
                            + "director     TEXT, "     //DVD only
                            + "mainActor    TEXT"       //DVD only
                            + ")"
            );
            stmt.close();
            connection.commit();
            connection.close();
        } catch (Exception e) {
            System.out.println("Item Table error: " + e.getClass().getName() + ": " +e.getMessage());
            return false;
        }
        return true;
    }

    private boolean createMemberTable() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = getDatConnection();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS " + MEMBER_TABLE + " "
                             + "(ID                  INTEGER PRIMARY KEY UNIQUE NOT NULL, "
                             + "name                 TEXT, "
                             + "fines                DOUBLE PRECISION, "
                             + "canCheckout          BOOLEAN, "
                             + "isLibrarian          BOOLEAN"
                             + ")"
            );
            stmt.close();
            connection.commit();
            connection.close();
        } catch (Exception e) {
            System.out.println("Member Table error: " + e.getClass().getName() + ": " +e.getMessage());
            return false;
        }
        return true;
    }


    Connection getDatConnection() throws SQLException {
        try {
            return DriverManager.getConnection(DATABASE_NAME);
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getClass().getName() + ": " +e.getMessage());
            throw e;
        }
    }
}
