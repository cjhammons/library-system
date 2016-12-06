package com.kraken.UserInterface;

import com.kraken.DataStructures.Members.Member;
import com.kraken.Database.DatabaseManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static com.kraken.main.WINDOW_DIMENSION;

/**
 * Created by Curtis on 12/6/2016.
 */
public class PrintMemberList {
    private JPanel printMemberPanel;
    private JList list1;
    private JButton backButton;

    public PrintMemberList() {
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

        DatabaseManager databaseManager = new DatabaseManager();
        List<Member> list = databaseManager.getAllMembers();
        List<String> stringList = new ArrayList<>();
        for (Member member : list){
            String add = "Name: " + member.getName()
                    + ", ID: " + member.getMemberId()
                    + ", Librarian: " + member.isLibrarian()
                    + ", Can check out: " + member.canCheckOut()
                    + ", Fines: " + member.getFines();

            stringList.add(add);
        }
        list1.setListData(stringList.toArray());
    }

    public JPanel getPrintMemberPanel() {
        return printMemberPanel;
    }
}
