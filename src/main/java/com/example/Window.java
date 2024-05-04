package com.example;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window {

    JFrame window;
    
    public Window(){
        window = new JFrame("Dean's Math Solver");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new JLabel("text"), BorderLayout.CENTER);
        window.setBounds(0,0,500,400);
        window.setVisible(true);
    }

}
