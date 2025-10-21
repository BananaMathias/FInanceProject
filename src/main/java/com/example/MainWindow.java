package com.example;

import javax.swing.*;
import javax.swing.JFrame;


public class MainWindow {

    private JTabbedPane tabbedPane;
    private MainWindowPanel mainWindowPanel;
    private TransactionsPanel transactionsPanel;
    private final JFrame jFrame;

    public MainWindow(MainWindowPanel mainWindowPanel, TransactionsPanel transactionsPanel){
        this.transactionsPanel = transactionsPanel;
        this.mainWindowPanel = mainWindowPanel;
        jFrame = createMainWindowFrame();

    }

    private JFrame createMainWindowFrame(){
        JFrame jFrame = new JFrame("FinanceTracker");
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(1500, 800);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        //jFrame.setLayout(new BorderLayout());
        //jFrame.add(mainWindowPanel, BorderLayout.NORTH);
        jFrame.add(createTabbedpane());
        return jFrame;
    }

    private JTabbedPane createTabbedpane(){
        tabbedPane = new JTabbedPane();
        tabbedPane.add("Main page", this.mainWindowPanel);
        tabbedPane.add("Transactions page", this.transactionsPanel);
        return tabbedPane;
    }
    public void show() {
        jFrame.setVisible(true);
    }
}
