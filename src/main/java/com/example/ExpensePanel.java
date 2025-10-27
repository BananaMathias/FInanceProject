package com.example;

import javax.swing.*;

public class ExpensePanel extends JPanel {

    CategoryData categoryData;
    String currentCategory;

    public ExpensePanel(CategoryData categoryData, String currentCategory){
        this.categoryData = categoryData;
        this.currentCategory = currentCategory;
        createLabels();
    }

    private void createLabels(){
        for (Transaction transaction : categoryData.getCategory(currentCategory).getTransactions() ){
            add(transaction.getTransactionCard());
        }
    }

}
