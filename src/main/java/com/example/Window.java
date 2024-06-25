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
import javax.swing.JCheckBox;
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
    public JTextArea calcProbToSolve; public JComboBox calcMenu; JTextArea calcSolution;
    public ProblemSolver solver = new ProblemSolver();
    
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

        JButton generatorbutton = new JButton("Problem Generator");
        JButton solverbutton = new JButton("Solver");
        JButton helpbutton = new JButton("Equations");
        JButton settingsbutton = new JButton("Settings");
        JButton infobutton = new JButton("Info");

        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        generatorbutton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        solverbutton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        helpbutton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        settingsbutton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        infobutton.setAlignmentX(JButton.CENTER_ALIGNMENT);

        generatorbutton.setActionCommand("generator");
        generatorbutton.addActionListener(this);
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
        contentPane.add(generatorbutton);
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

    public void setupGeneratorWindow(){
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

            //setup box for entering problem
                JTextArea calcText = new JTextArea("Type Problem Here");
                calcText.setLineWrap(true);
                calcText.setEditable(true);
                calcPanel.add(calcText);

            //setup box for settings and check buttons
                JPanel buttonPanel1 = new JPanel(new FlowLayout());
                JButton calcSettings = new JButton("Settings");
                buttonPanel1.add(calcSettings);
                JButton calcCheck = new JButton("Check");
                buttonPanel1.add(calcCheck);
                calcPanel.add(buttonPanel1);
                    calcSettings.setActionCommand("generatorSettings");
                    calcSettings.addActionListener(this);
                    calcCheck.setActionCommand("generatorCheck");
                    calcCheck.addActionListener(this);

            //setup box for displaying solution
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
                calcMenu = new JComboBox(new String[]{"Test", "option 22222222222222222222", "option 3","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1",});
                calcPanel.add(calcMenu);

                calcProbToSolve = new JTextArea("Type Problem Here");
                calcProbToSolve.setLineWrap(true);
                calcProbToSolve.setEditable(true);
                calcProbToSolve.setToolTipText("Type Problem Here");
                calcPanel.add(calcProbToSolve);

                JButton calcSolve = new JButton("Solve");
                calcPanel.add(calcSolve);
                calcSolve.setActionCommand("calcSolve");
                calcSolve.addActionListener(this);

                calcSolution = new JTextArea("Solution Appears Here");
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
        JLabel label = new JLabel("Equations");
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
                JComboBox calcMenu = new JComboBox(new String[]{"Test", "option 22222222222222222222", "option 3","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1","option 1",});
                calcPanel.add(calcMenu);

                JTextArea calcText = new JTextArea("Hello. This is a little project I've been working on recently to help me review math & physics. This program includes a Solver made to solve a variety of types of math problems, along with a Equations section to refresh you on any equations you might have forgotten.");
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
        JTextArea text = new JTextArea("Hello. This is a little project I've been working on recently to help me review math & physics. This program includes a Solver made to solve a variety of types of math problems, along with a Equations section to refresh you on any equations you might have forgotten.");
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
        switch(e.getActionCommand()){
            case "solver": window.getContentPane().removeAll(); window.repaint(); setupSolverWindow(); break;
            case "help": window.getContentPane().removeAll(); window.repaint(); setupHelpWindow(); break;
            case "settings": window.getContentPane().removeAll(); window.repaint(); setupSettingsWindow(); break;
            case "info": window.getContentPane().removeAll(); window.repaint(); setupInfoWindow(); break;
            case "backToMain" : window.getContentPane().removeAll(); window.repaint(); startupSetup(); break;
            case "generator": window.getContentPane().removeAll(); window.repaint(); setupGeneratorWindow(); break;
            case "generatorCheck": window.getContentPane().removeAll(); window.repaint(); checkGeneratedProblem(); break;
            case "generatorSettings": window.getContentPane().removeAll(); window.repaint(); openGeneratorSettings(); break;
            case "calcSolve": calcSolution.setText(solver.calcSolve(calcMenu.getSelectedItem().toString(), calcProbToSolve.getText())); break;
            default: window.getContentPane().removeAll(); window.repaint(); startupSetup();
        }
        
    }

//TODO - GENERATOR METHODS

//TODO - PROBLEM GENERATION SETTINGS: 
    //include option to pick between whole and decimal answers & given numbers in generated problems
    //option to see correct answer or not, etc.
    private void openGeneratorSettings() {
        window.getContentPane().removeAll();
        window.repaint();

        window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
            JPanel option1 = new JPanel(new GridLayout());
            JTextArea option1Label = new JTextArea("Use decimals in generated problems. If disabled, problems will only contain whole numbers");
            option1Label.setLineWrap(true); option1Label.setEditable(false); option1Label.setHighlighter(null); 
            JCheckBox option1CheckBox = new JCheckBox();
//read settings.txt and change accordingly
            //option1checkbox.setselected() ...
            option1.add(option1Label); option1.add(option1CheckBox); window.getContentPane().add(option1);

            JPanel option2 = new JPanel(new GridLayout());
            JTextArea option2Label = new JTextArea("See correct answer after pressing the 'Solve' button. If disabled, the program will only say whether your answer is correct or incorrect");
            option2Label.setLineWrap(true); option2Label.setEditable(false); option2Label.setHighlighter(null);
            JCheckBox option2CheckBox = new JCheckBox();
            option2.add(option2Label); option2.add(option2CheckBox); window.getContentPane().add(option2); window.getContentPane().add(Box.createVerticalStrut(200));

            JButton backButton = new JButton("Back");
            backButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            backButton.setActionCommand("generator");
            backButton.addActionListener(this);
            window.getContentPane().add(backButton); window.getContentPane().add(Box.createVerticalStrut(15));
            window.revalidate();
    }

//TODO - THIS WILL PROBABLY BE THE MOST COMPLICATED THING TO SETUP IN THIS PROGRAM
    private void checkGeneratedProblem() {

    }
    
}


