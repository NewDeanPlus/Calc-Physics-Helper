package com.example;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window {

    //https://docs.oracle.com/javase%2Ftutorial%2Fuiswing%2F%2F/components/frame.html

    JFrame window;
    
    public Window(){
        window = new JFrame("Dean's Math Solver");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new JLabel("text"), BorderLayout.CENTER);
        window.setBounds(0,0,500,400);
        window.setVisible(true);
    }

}
