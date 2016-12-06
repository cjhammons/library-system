package com.kraken.UserInterface;

import com.kraken.DataStructures.Members.Member;
import com.kraken.Database.DatabaseManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import static com.kraken.main.WINDOW_DIMENSION;

/**
 * Created by Curtis on 12/6/2016.
 */
public class SearchMember {
    private JButton backButton;
    private JButton searchButton;
    private JTextField searchTextField;
    private JList memberList;
    private JPanel searchMemberPanel;

    public SearchMember() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("start screen");
                frame.setContentPane(new MemberTransaction().getMembertransactionsPanel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(WINDOW_DIMENSION);
                frame.pack();
                frame.setVisible(true);
            }
        });

        searchTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                searchTextField.setText("");
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search();
            }
        });
    }

    void search() {
        DatabaseManager databaseManager = new DatabaseManager();
        String param = searchTextField.getText();
        List<Member> list = databaseManager.searchMember(param);
        List<String> stringList = new ArrayList<>();
        for (Member member : list){
            String add = "Name: " + member.getName()
                    + ", ID: " + member.getMemberId()
                    + ", Librarian: " + member.isLibrarian()
                    + ", Can check out: " + member.canCheckOut()
                    + ", Fines: " + member.getFines();

            stringList.add(add);
        }
        memberList.setListData(stringList.toArray());
    }

    public JPanel getSearchMemberPanel() {
        return searchMemberPanel;
    }
}
