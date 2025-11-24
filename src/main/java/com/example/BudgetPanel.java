package com.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BudgetPanel extends JPanel {

    private JLabel categoryLabel;
    private JComboBox categoryOptions;
    private JLabel budgetLabel;
    //private String[] categories = {"Food", "Transportation", "Entertainment", "Personal"};// Needs data from CategoryData
    private JButton transactionButton;

    public BudgetPanel(){
        //setLayout(new BorderLayout(50,50));
        setBackground(Color.GRAY);

        //this.setSize(10,50);
    }

    public JComboBox addComboBox(ArrayList<String> categories){
        categoryOptions = new JComboBox(categories.toArray());
        //categoryOptions.setSelectedIndex(0);
        categoryOptions.setSize(100,200);
        addCategoryLabel();
        this.add(categoryOptions);
        addBudgetLabel();
        addTranscationButton();

        return categoryOptions;
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

    public void setCategoryOptions(JComboBox box){
        categoryOptions = box;
    }

}
