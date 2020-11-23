package queuestack.view;

import javax.swing.JFrame;
import java.awt.*;

public class MyFrame extends JFrame{
     MyPanel panel;

    MyFrame(MyPanel p) { 
        panel = p;
        add(panel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(panel);
        pack();
        setVisible(true);
    }
}