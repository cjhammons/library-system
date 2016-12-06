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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.kraken.main.WINDOW_DIMENSION;

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
    private JButton backButton;

    Item mItem;
    Type mType;

    public addItem(Type type) {
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
        titleField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                titleField.setText("");
            }
        });
        genreField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                genreField.setText("");
            }
        });
        costField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                costField.setText("");
            }
        });
        authorField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                authorField.setText("");
            }
        });
        isbnField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                isbnField.setText("");
            }
        });
        accessPointField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                accessPointField.setText("");
            }
        });
        locationField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                locationField.setText("");
            }
        });
        numDiscsField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                numDiscsField.setText("");
            }
        });
        runtimeField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                runtimeField.setText("");
            }
        });
        artistField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                artistField.setText("");
            }
        });
        directorField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                directorField.setText("");
            }
        });
        mainActorField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mainActorField.setText("");
            }
        });
        mType = type;
        switch (mType) {
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

    public Item createNewItem() {
        switch (mType) {
            case HardCopy:
                mItem = new HardCopy();
                ((HardCopy) mItem).setAuthor(authorField.getText());
                ((HardCopy) mItem).setISBN(Integer.parseInt(isbnField.getText()));
                ((HardCopy) mItem).setLocationInLibrary(locationField.getText());
                break;
            case eBook:
                mItem = new EBook();
                ((EBook) mItem).setAuthor(authorField.getText());
                ((EBook) mItem).setISBN(Integer.parseInt(isbnField.getText()));
                ((EBook) mItem).setAccessPoint(accessPointField.getText());
                break;
            case AudioBook:
                mItem = new AudioBook();
                ((AudioBook) mItem).setAuthor(authorField.getText());
                ((AudioBook) mItem).setISBN(Integer.parseInt(isbnField.getText()));
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

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        add_item_panel = new JPanel();
        add_item_panel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(16, 3, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("Add Item: ");
        add_item_panel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        add_item_panel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 2, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        add_item_panel.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 7, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        genreField = new JTextField();
        genreField.setText("Item Genre: ");
        add_item_panel.add(genreField, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        costField = new JTextField();
        costField.setText("Item cost: ");
        add_item_panel.add(costField, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        authorField = new JTextField();
        authorField.setText("Item Author: ");
        add_item_panel.add(authorField, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        isbnField = new JTextField();
        isbnField.setText("Item ISBN: ");
        add_item_panel.add(isbnField, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        titleField = new JTextField();
        titleField.setText("Item Title: ");
        add_item_panel.add(titleField, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        accessPointField = new JTextField();
        accessPointField.setText("Item access point: ");
        add_item_panel.add(accessPointField, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        locationField = new JTextField();
        locationField.setText("Item location: ");
        add_item_panel.add(locationField, new com.intellij.uiDesigner.core.GridConstraints(8, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        numDiscsField = new JTextField();
        numDiscsField.setText("Item number of discs: ");
        add_item_panel.add(numDiscsField, new com.intellij.uiDesigner.core.GridConstraints(9, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        runtimeField = new JTextField();
        runtimeField.setText("Item runtime: ");
        add_item_panel.add(runtimeField, new com.intellij.uiDesigner.core.GridConstraints(10, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        artistField = new JTextField();
        artistField.setText("Item artist: ");
        add_item_panel.add(artistField, new com.intellij.uiDesigner.core.GridConstraints(11, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        directorField = new JTextField();
        directorField.setText("Item director: ");
        add_item_panel.add(directorField, new com.intellij.uiDesigner.core.GridConstraints(12, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        mainActorField = new JTextField();
        mainActorField.setText("Item mainActor: ");
        add_item_panel.add(mainActorField, new com.intellij.uiDesigner.core.GridConstraints(13, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        addButton = new JButton();
        addButton.setText("Add");
        add_item_panel.add(addButton, new com.intellij.uiDesigner.core.GridConstraints(14, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        backButton = new JButton();
        backButton.setText("back");
        add_item_panel.add(backButton, new com.intellij.uiDesigner.core.GridConstraints(15, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return add_item_panel;
    }
}
