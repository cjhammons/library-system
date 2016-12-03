package com.kraken.Database;

import com.kraken.DataStructures.Items.Books.Book;
import com.kraken.DataStructures.Items.Books.EBook;
import com.kraken.DataStructures.Items.Books.Enumerations.Status;
import com.kraken.DataStructures.Items.Books.Enumerations.Type;
import com.kraken.DataStructures.Items.Books.HardCopy;
import com.kraken.DataStructures.Items.DiscItems.AudioBook;
import com.kraken.DataStructures.Items.DiscItems.CD;
import com.kraken.DataStructures.Items.DiscItems.DVD;
import com.kraken.DataStructures.Items.DiscItems.DiscItem;
import com.kraken.DataStructures.Items.Item;

import java.lang.reflect.Member;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Curtis on 11/16/2016.
 */
public class DatabaseManager {

    static final String ITEM_TABLE = "itemTable";
    static final String MEMBER_TABLE = "memberTableName";
    static final String DATABASE_NAME = "jdbc:sqlite:library.db";

    public DatabaseManager()  {
        initializeTables();
    }

    /**
     * Builds the Tables if it doesn't exist.
     * @return true if success, false if not
     */
    public boolean initializeTables(){
        try {
//            Class.forName("org.sqlite.JDBC");
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
            String values = "VALUES (" + item.getCost() + ",'" + item.getGenre() + "','" + item.getTitle() + "','" + item.getStatus() + "','" + item.getType() +"'";
            //Adjust fields and values depending on what kind of item this is.
            if (item instanceof Book) {
                fields += "author,isbn,";
                values += ",'" + ((Book) item).getAuthor() + "'," + ((Book) item).getISBN();
                if (item instanceof EBook) {
                    fields += "accessPnt";
                    values += ",'" + ((EBook) item).getAccessPoint() + "'";
                } else if (item instanceof HardCopy) {
                    fields += "location";
                    values += ",'" + ((HardCopy) item).getLocationInLibrary()+"'";
                }
                /* wake me up inside */
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
            connection.setAutoCommit(true);
            connection.close();
        } catch (Exception e) {
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
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Delete Item failed.");
            printItemTable();
            return false;
        }

        return true;
    }

    public boolean checkOut(Item item) {
        try {
            Connection c = getDatConnection();
            Statement statement = c.createStatement();

            String sql = "UPDATE " + ITEM_TABLE + " set "
                    + "status = " + Status.CheckedOut.toString() + " "
                    + "where ID = " + item.getItemID() + ";";
        } catch (Exception e) {
            System.out.println("Item Checkout failed: " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean checkIn(Item item) {
        try {
            Connection c = getDatConnection();
            Statement statement = c.createStatement();

            String sql = "UPDATE " + ITEM_TABLE + " set "
                    + "status = " + Status.InLibrary.toString() + " "
                    + "where ID = " + item.getItemID() + ";";
        } catch (Exception e) {
            System.out.println("Item Checkin failed: " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean renewItem(Item item) {
        try {
            Connection c = getDatConnection();
            Statement statement = c.createStatement();

            String sql = "UPDATE " + ITEM_TABLE + " set "
                    + "status = " + Status.CheckedOut.toString() + " "
                    + "where ID = " + item.getItemID() + ";";
        } catch (Exception e) {
            System.out.println("Item renew failed: " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean payFine(Item item){
        try {
            Connection c = getDatConnection();
            Statement statement = c.createStatement();

            String sql = "UPDATE " + ITEM_TABLE + " set "
                    + "cost = 0"
                    + "where ID = " + item.getItemID() + ";";
        } catch (Exception e) {
            System.out.println("Item Checkout failed: " + e.getMessage());
            return false;
        }
        return true;
    }

//    boolean updateItem(Item item) {
//
//    }

    /**
     * Queries the database for All the items and returns them in a neat little list.
     * @return List of all items.
     */
    public List<Item> getAllItems() {
        List<Item> list = new ArrayList<>();
        try {
            Connection c = getDatConnection();
            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + ITEM_TABLE + ";");

            while (resultSet.next()) {
                Item item;
                /* Rock me mama like a wagon wheel */
                Type type = Type.valueOf(resultSet.getString("type_"));

                //Type specific field
                switch (type) {
                    case HardCopy:
                        item = new HardCopy();
                        ((HardCopy) item).setAuthor(resultSet.getString("author"));
                        ((HardCopy) item).setISBN(resultSet.getInt("isbn"));
                        ((HardCopy) item).setLocationInLibrary(resultSet.getString("location"));
                        break;
                    case eBook:
                        item = new EBook();
                        ((EBook) item).setAuthor(resultSet.getString("author"));
                        ((EBook) item).setISBN(resultSet.getInt("isbn"));
                        ((EBook) item).setAccessPoint(resultSet.getString("accessPnt"));
                        break;
                    case AudioBook:
                        item = new AudioBook();
                        ((AudioBook) item).setAuthor(resultSet.getString("author"));
                        ((AudioBook) item).setISBN(resultSet.getInt("isbn"));
                        ((AudioBook) item).setNumDiscs(resultSet.getInt("numDiscs"));
                        ((AudioBook) item).setRuntime(resultSet.getString("runTime"));
                        break;
                    case CD:
                        item = new CD();
                        ((CD) item).setNumDiscs(resultSet.getInt("numDiscs"));
                        ((CD) item).setRuntime(resultSet.getString("runTime"));
                        ((CD) item).setArtist(resultSet.getString("artist"));
                        break;
                    case DVD:
                    default:
                        item = new DVD();
                        ((DVD) item).setNumDiscs(resultSet.getInt("numDiscs"));
                        ((DVD) item).setRuntime(resultSet.getString("runTime"));
                        ((DVD) item).setDirector(resultSet.getString("director"));
                        ((DVD) item).setMainActor(resultSet.getString("mainActor"));
                        break;
                }
                //Generic fields
                item.setItemID(resultSet.getInt("ID"));
                item.setCost(resultSet.getInt("cost"));
                item.setGenre(resultSet.getString("genre"));
                item.setTitle(resultSet.getString("title"));
                item.setStatus(Status.valueOf(resultSet.getString("status")));
                item.setType(type); //from earlier
                list.add(item);
            }
            statement.close();
            c.commit();
            c.close();
        } catch (Exception e){
            e.getMessage();
        }
        return list;
    }

    /**
     * Prints all the basic info of the items in the table to the console.
     * For debugging and testing purposes only.
     */
    public void printItemTable() {
        try {
            Connection c = getDatConnection();
            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + ITEM_TABLE + ";");

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String title = resultSet.getString("title");

                System.out.println("ID: " + id);
                System.out.println("Title: " + title);
                System.out.println();
            }
            statement.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            e.getMessage();
        }
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
                            + "location     TEXT, "     //hardcopies only
                            + "numDiscs     INTEGER, "  //DiscItems only
                            + "runTime      TEXT, "     //DiscItems only
                            + "artist       TEXT, "     //CD only
                            + "director     TEXT, "     //DVD only
                            + "mainActor    TEXT"       //DVD only
                            + ");"
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
                             + ");"
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


    /*I've become so numb*/

    Connection getDatConnection() throws Exception {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(DATABASE_NAME);
            connection.setAutoCommit(false);
            return connection;
        } catch (Exception e) {
            System.out.println("Database error: " + e.getClass().getName() + ": " +e.getMessage());
            throw e;
        }
    }
}
