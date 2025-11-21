package com.example;

import javax.swing.*;
import javax.swing.JFrame;


public class MainWindow {

    private JTabbedPane tabbedPane;
    private BudgetPanel budgetPanel;
    private TransactionsPanel transactionsPanel;
    private final JFrame jFrame;

    public MainWindow(BudgetPanel budgetPanel, TransactionsPanel transactionsPanel){
        this.transactionsPanel = transactionsPanel;
        this.budgetPanel = budgetPanel;
        jFrame = createMainWindowFrame();

    }

    private JFrame createMainWindowFrame(){
        JFrame jFrame = new JFrame("FinanceTracker");
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(1000, 600);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        //jFrame.setLayout(new BorderLayout());
        //jFrame.add(budgetPanel, BorderLayout.NORTH);
        jFrame.add(createTabbedpane());
        return jFrame;
    }

    private JTabbedPane createTabbedpane(){
        tabbedPane = new JTabbedPane();
        tabbedPane.add("Main page", this.budgetPanel);
        tabbedPane.add("Transactions page", this.transactionsPanel);
        return tabbedPane;
    }
    public void show() {
        jFrame.setVisible(true);
    }
}
