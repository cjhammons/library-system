package com.kraken.UserInterface;

import com.kraken.DataStructures.Items.Books.EBook;
import com.kraken.DataStructures.Items.Books.Enumerations.Status;
import com.kraken.DataStructures.Items.Books.Enumerations.Type;
import com.kraken.DataStructures.Items.Books.HardCopy;
import com.kraken.DataStructures.Items.DiscItems.AudioBook;
import com.kraken.DataStructures.Items.DiscItems.CD;
import com.kraken.DataStructures.Items.DiscItems.DVD;
import com.kraken.DataStructures.Items.Item;
import com.kraken.Database.DatabaseManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jessica on 12/5/16.
 */
public class addItem {
    private JTextField titleField;
    private JTextField hardCopyTextField;
    private JPanel add_item_panel;
    private JTextField genreField;
    private JTextField costField;
    private JTextField authorField;
    private JTextField isbnField;
    private JTextField accessPointField;
    private JTextField locationField;
    private JTextField numDiscsField;
    private JTextField runtimeField;
    private JTextField artistField;
    private JTextField directorField;
    private JTextField mainActorField;
    private JButton addButton;

    Item mItem;
    Type mType;
    public addItem(Type type)
    {
        mType = type;
        switch (mType){
            case HardCopy:
                accessPointField.setVisible(false);
                numDiscsField.setVisible(false);
                runtimeField.setVisible(false);
                artistField.setVisible(false);
                directorField.setVisible(false);
                mainActorField.setVisible(false);
                break;
            case eBook:
                locationField.setVisible(false);
                numDiscsField.setVisible(false);
                runtimeField.setVisible(false);
                artistField.setVisible(false);
                directorField.setVisible(false);
                mainActorField.setVisible(false);
                break;
            case AudioBook:
                accessPointField.setVisible(false);
                locationField.setVisible(false);
                numDiscsField.setVisible(false);
                runtimeField.setVisible(false);
                artistField.setVisible(false);
                directorField.setVisible(false);
                mainActorField.setVisible(false);
                break;
            case DVD:
                authorField.setVisible(false);
                isbnField.setVisible(false);
                accessPointField.setVisible(false);
                locationField.setVisible(false);
                artistField.setVisible(false);
                break;
            case CD:
                authorField.setVisible(false);
                isbnField.setVisible(false);
                accessPointField.setVisible(false);
                locationField.setVisible(false);
                directorField.setVisible(false);
                mainActorField.setVisible(false);
                break;
        }

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewItem();
            }
        });
    }
    public void setVisibilities() {
        hardCopyTextField.setVisible(false);

    }

    public Item createNewItem(){
        switch (mType){
            case HardCopy:
                mItem = new HardCopy();
                ((HardCopy)mItem).setAuthor(authorField.getText());
                ((HardCopy)mItem).setISBN(Integer.parseInt(isbnField.getText()));
                ((HardCopy)mItem).setLocationInLibrary(locationField.getText());
                break;
            case eBook:
                mItem = new EBook();
                ((EBook) mItem).setAuthor(authorField.getText());
                ((EBook) mItem).setISBN(Integer.parseInt(isbnField.getText()));
                ((EBook) mItem).setAccessPoint(accessPointField.getText());
                break;
            case AudioBook:
                mItem = new AudioBook();
                ((AudioBook)mItem).setAuthor(authorField.getText());
                ((AudioBook)mItem).setISBN(Integer.parseInt(isbnField.getText()));
                break;
            case DVD:
                mItem = new DVD();
                ((DVD) mItem).setNumDiscs(Integer.parseInt(numDiscsField.getText()));
                ((DVD) mItem).setRuntime(runtimeField.getText());
                ((DVD) mItem).setDirector(directorField.getText());
                ((DVD) mItem).setMainActor(mainActorField.getText());
                break;
            case CD:
                mItem = new CD();
                ((CD) mItem).setNumDiscs(Integer.parseInt(numDiscsField.getText()));
                ((CD) mItem).setRuntime(runtimeField.getText());
                break;
        }
        mItem.setCost(Integer.parseInt(costField.getText()));
        mItem.setGenre(genreField.getText());
        mItem.setTitle(titleField.getText());
        mItem.setStatus(Status.InLibrary);

        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.addItem(mItem);
        databaseManager.printItemTable();

        return mItem;
    }

    public JPanel getAdd_item_panel() {
        return add_item_panel;
    }
}
