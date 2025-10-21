package com.example;

import javax.swing.*;
import java.awt.*;

public class MainWindowPanel extends JPanel {

    private JLabel categoryLabel;
    private JComboBox categoryOptions;
    private JLabel budgetLabel;
    private Budget[] budgets;
    private String[] categories = {"Food", "Transportation", "Entertainment", "Personal"};// Needs data from CategoryData
    private JButton transactionButton;

    public MainWindowPanel(){
        //setLayout(new BorderLayout(50,50));
        setBackground(Color.GRAY);
        addCategoryLabel();
        addComboBox();
        addBudgetLabel();
        addTranscationButton();
        //this.setSize(10,50);
    }

    private void addComboBox(){
        categoryOptions = new JComboBox(categories);
        //categoryOptions.setSelectedIndex(0);
        categoryOptions.setSize(100,200);
        this.add(categoryOptions);
    }

    private void addCategoryLabel(){
        categoryLabel = new JLabel("Current catagory");
        categoryLabel.setSize(100,100);
        this.add(categoryLabel);
    }

    private void addBudgetLabel(){
        budgetLabel = new JLabel("Select category");
        budgetLabel.setSize(100,100);
        this.add(budgetLabel);
    }

    private void addTranscationButton(){
        transactionButton = new JButton("Add transaction");
        transactionButton.setSize(50, 100);
        this.add(transactionButton);
    }

    public JButton getTransactionButton(){
        return transactionButton;
    }
    public JLabel getBudgetLabel(){
        return budgetLabel;
    }
    public JComboBox getCategoryOptions(){
        return categoryOptions;
    }
    public String[] getCategories(){
        return categories;
    }

}
