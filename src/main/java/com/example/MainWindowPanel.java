package com.example;


import javax.swing.*;
import java.awt.*;

public class MainWindowPanel extends JPanel {

    BudgetPanel budgetPanel;

    public MainWindowPanel(){
        budgetPanel = new BudgetPanel();
        setLayout(new BorderLayout());
        add(budgetPanel, BorderLayout.NORTH);
    }

    public BudgetPanel getBudgetPanel(){
        return budgetPanel;
    }
}
