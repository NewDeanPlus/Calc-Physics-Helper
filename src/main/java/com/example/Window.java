package com.example;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.LayoutManager2;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Window implements ActionListener{

    //https://docs.oracle.com/javase%2Ftutorial%2Fuiswing%2F%2F/components/frame.html

    public JFrame window;
    public JButton solverbutton;
    
    public Window(){
        window = new JFrame("Dean's Math Solver");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //window.getContentPane().add(new JLabel("text"));
        window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
        window.setBounds(0,0,500,400);
        window.setVisible(true);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        startupSetup();
    }

    public void startupSetup(){
        Container contentPane = window.getContentPane();
        window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Dean's Math Helper");
        label.setFont(new Font("Sans Serif", Font.BOLD, 30));
        solverbutton = new JButton("Solver");
        JButton helpbutton = new JButton("Concepts");
        JButton settingsbutton = new JButton("Settings");
        JButton infobutton = new JButton("Info");

        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        solverbutton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        helpbutton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        settingsbutton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        infobutton.setAlignmentX(JButton.CENTER_ALIGNMENT);

        solverbutton.setActionCommand("solver");
        solverbutton.addActionListener(this);
        helpbutton.setActionCommand("help");
        helpbutton.addActionListener(this);
        settingsbutton.setActionCommand("settings");
        settingsbutton.addActionListener(this);
        infobutton.setActionCommand("info");
        infobutton.addActionListener(this);

        contentPane.add(Box.createVerticalGlue());
        contentPane.add(label);
        contentPane.add(Box.createRigidArea(new Dimension(0, 15)));
        contentPane.add(solverbutton);
        contentPane.add(Box.createRigidArea(new Dimension(0, 15)));
        contentPane.add(helpbutton);
        contentPane.add(Box.createRigidArea(new Dimension(0, 15)));
        contentPane.add(settingsbutton);
        contentPane.add(Box.createRigidArea(new Dimension(0, 15)));
        contentPane.add(infobutton);
        contentPane.add(Box.createVerticalGlue());
        window.setVisible(true);
    }

    public void setupSolverWindow(){
        window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Solver");
        label.setFont(new Font("Sans Serif", Font.BOLD, 30));
        JButton backbutton = new JButton("Back");

        //actual options
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
        panel1.setBounds(0, 0, 300, 400);
        JTabbedPane tab1 = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
//TODO - this section is also going to get very complicated very quickly, work on a way to simplify this.
//maybe add text file to get text from depending on combo box menu option
//have solve button also check combo box menu and use math classes to do the math
            JPanel calcPanel = new JPanel();
            calcPanel.setLayout(new BoxLayout(calcPanel, BoxLayout.Y_AXIS));
                JComboBox calcMenu = new JComboBox(new String[]{"option 1", "option 22222222222222222222", "option 3","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1",});
                calcPanel.add(calcMenu);

                JTextArea calcText = new JTextArea("Type Problem Here");
                calcText.setLineWrap(true);
                calcText.setEditable(true);
                calcPanel.add(calcText);

                JButton calcSolve = new JButton("Solve");
                calcPanel.add(calcSolve);

                JTextArea calcSolution = new JTextArea("Solution Appears Here");
                calcSolution.setLineWrap(true);
                calcSolution.setEditable(false);
                calcPanel.add(calcSolution);


            JPanel physPanel = new JPanel(new FlowLayout());
                JComboBox physMenu = new JComboBox(new String[]{"option 1", "option 22222222222222222222", "option 3","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1",});
                physPanel.add(physMenu);
            JPanel egrPanel = new JPanel(new FlowLayout());
                JComboBox egrMenu = new JComboBox(new String[]{"option 1", "option 22222222222222222222", "option 3","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1",});
                egrPanel.add(egrMenu);
        tab1.addTab("Calculus", calcPanel);
        tab1.addTab("Physics", physPanel);
        tab1.addTab("Engineering", egrPanel);
        panel1.add(Box.createHorizontalStrut(5));
        panel1.add(tab1);
        panel1.add(Box.createHorizontalStrut(5));

        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        backbutton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        panel1.setAlignmentX(JTextArea.CENTER_ALIGNMENT);

        window.getContentPane().add(label);
        window.getContentPane().add(Box.createRigidArea(new Dimension(0, 15)));
        window.getContentPane().add(panel1);
        window.getContentPane().add(Box.createRigidArea(new Dimension(0, 15)));
        window.getContentPane().add(backbutton);
        window.getContentPane().add(Box.createRigidArea(new Dimension(0, 15)));
        window.revalidate();

        backbutton.setActionCommand("back");
        backbutton.addActionListener(this);
    }

    public void setupHelpWindow(){
        window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Concepts");
        label.setFont(new Font("Sans Serif", Font.BOLD, 30));
        JButton backbutton = new JButton("Back");

        //actual options
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
        panel1.setBounds(0, 0, 300, 400);
        JTabbedPane tab1 = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
//TODO - this section is going to get very complicated very quickly, work on a way to simplify this.
            JPanel calcPanel = new JPanel();
            calcPanel.setLayout(new BoxLayout(calcPanel, BoxLayout.Y_AXIS));
                JComboBox calcMenu = new JComboBox(new String[]{"option 1", "option 22222222222222222222", "option 3","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1",});
                calcPanel.add(calcMenu);

                JTextArea calcText = new JTextArea("Hello. This is a little project I've been working on recently to help me review math & physics. This program includes a Solver made to solve a variety of types of math problems, along with a Concepts section to refresh you on any concepts you might have forgotten.");
                calcText.setLineWrap(true);
                calcText.setEditable(false);
                calcPanel.add(calcText);

            JPanel physPanel = new JPanel(new FlowLayout());
                JComboBox physMenu = new JComboBox(new String[]{"option 1", "option 22222222222222222222", "option 3","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1",});
                physPanel.add(physMenu);
            JPanel egrPanel = new JPanel(new FlowLayout());
                JComboBox egrMenu = new JComboBox(new String[]{"option 1", "option 22222222222222222222", "option 3","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1",});
                egrPanel.add(egrMenu);
        tab1.addTab("Calculus", calcPanel);
        tab1.addTab("Physics", physPanel);
        tab1.addTab("Engineering", egrPanel);
        panel1.add(Box.createHorizontalStrut(5));
        panel1.add(tab1);
        panel1.add(Box.createHorizontalStrut(5));

        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        backbutton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        panel1.setAlignmentX(JTextArea.CENTER_ALIGNMENT);

        window.getContentPane().add(label);
        window.getContentPane().add(Box.createRigidArea(new Dimension(0, 15)));
        window.getContentPane().add(panel1);
        window.getContentPane().add(Box.createRigidArea(new Dimension(0, 15)));
        window.getContentPane().add(backbutton);
        window.getContentPane().add(Box.createRigidArea(new Dimension(0, 15)));
        window.revalidate();

        backbutton.setActionCommand("back");
        backbutton.addActionListener(this);
    }

    public void setupSettingsWindow(){
        window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Settings");
        label.setFont(new Font("Sans Serif", Font.BOLD, 30));
        JButton backbutton = new JButton("Back");

        //actual options
        JPanel panel1 = new JPanel(new FlowLayout());
        JButton option1 = new JButton("Option1");
        JButton option2 = new JButton("Option2");
        panel1.add(option1);
        panel1.add(option2);

        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        backbutton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        panel1.setAlignmentX(JTextArea.CENTER_ALIGNMENT);

        window.getContentPane().add(label);
        window.getContentPane().add(Box.createRigidArea(new Dimension(0, 15)));
        window.getContentPane().add(panel1);
        window.getContentPane().add(Box.createRigidArea(new Dimension(0, 15)));
        window.getContentPane().add(backbutton);
        window.getContentPane().add(Box.createRigidArea(new Dimension(0, 15)));
        window.revalidate();

        backbutton.setActionCommand("back");
        backbutton.addActionListener(this);

    }

    public void setupInfoWindow(){
        //https://stackoverflow.com/questions/15694107/how-to-layout-multiple-panels-on-a-jframe-java
    //TODO - FIGURE OUT HOW TO LAY STUFF OUT CORRECTLY
        window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Info");
        label.setFont(new Font("Sans Serif", Font.BOLD, 30));
        JButton backbutton = new JButton("Back");

        //panel with text
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
        JTextArea text = new JTextArea("Hello. This is a little project I've been working on recently to help me review math & physics. This program includes a Solver made to solve a variety of types of math problems, along with a Concepts section to refresh you on any concepts you might have forgotten.");
        text.setLineWrap(true);
        text.setEditable(false);
        text.setHighlighter(null);
        panel1.add(Box.createHorizontalStrut(70));
        panel1.add(text);
        panel1.add(Box.createHorizontalStrut(70));

        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        backbutton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        panel1.setAlignmentX(JTextArea.CENTER_ALIGNMENT);

        window.getContentPane().add(label);
        window.getContentPane().add(Box.createRigidArea(new Dimension(0, 15)));
        window.getContentPane().add(panel1);
        window.getContentPane().add(Box.createRigidArea(new Dimension(0, 15)));
        window.getContentPane().add(backbutton);
        window.getContentPane().add(Box.createRigidArea(new Dimension(0, 15)));
        window.revalidate();

        backbutton.setActionCommand("back");
        backbutton.addActionListener(this);
    }

    public JFrame getWindow() {
        return window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        window.getContentPane().removeAll();
        window.repaint();
        switch(e.getActionCommand()){
            case "solver": setupSolverWindow(); break;
            case "help": setupHelpWindow(); break;
            case "settings": setupSettingsWindow(); break;
            case "info": setupInfoWindow(); break;
            case "backToMain" : startupSetup(); break;
            default: startupSetup();
        }
        
    }
    
}


