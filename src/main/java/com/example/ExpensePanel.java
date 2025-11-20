package com.example;

import javax.swing.*;
import java.awt.*;

public class ExpensePanel extends JPanel {

    CategoryData categoryData;
    String currentCategory;

    public ExpensePanel(CategoryData categoryData, String currentCategory){
        this.categoryData = categoryData;
        this.currentCategory = currentCategory;
        setMaximumSize(new Dimension(100,100));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //createLabels();
    }

    private void createLabels(){ // FEL GE CONTROLLER DETTA
        for (Transaction transaction : categoryData.getCategory(currentCategory).getTransactions() ){
            add(transaction.getTransactionCard());
        }
    }

}
