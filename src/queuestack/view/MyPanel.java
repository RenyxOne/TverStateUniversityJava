package queuestack.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerListener;
import java.util.Queue;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import queuestack.MyList;
import queuestack.MyQueue;
import queuestack.MyStack;


public class MyPanel extends JPanel {

    JTextField field;
    JButton pushButton;
    JButton switchToQueueButton;
    JButton switchToStackButton;
    JButton popButton;
    JList<Integer> list;
    BaseListModel baseModel;
    GridLayout layout;
    
    public MyPanel() {
        field = new JTextField("");
        pushButton  = new JButton("Push");
        popButton  = new JButton("Pop");
        baseModel = new BaseListModel(new MyList());

        switchToQueueButton  = new JButton("Switch to MyQueue");
        switchToStackButton  = new JButton("Switch to MyStack");
        baseModel.list.setSq(new MyQueue());

        list = new JList<>(baseModel);

        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                try {
                    int k = Integer.parseInt(field.getText().trim());
                    baseModel.addElement(k);
                    //validate();
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(MyPanel.this, "Error!");
                }
            } 
        });

        switchToQueueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baseModel.list.setSq(new MyQueue());
            }
        });

        switchToStackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baseModel.list.setSq(new MyStack());
            }
        });

        popButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baseModel.popElement();
            }
        });

        layout = new GridLayout(2, 3, 5, 5);
        setLayout(layout);



        add(field);
        add(pushButton);
        add(popButton);
        add(new JScrollPane(list));
        add(switchToQueueButton);
        add(switchToStackButton);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    
    
}
