package com.example;

import javax.swing.*;
import java.awt.*;

public class ExpensePanel extends JPanel {

    private String currentCategory;

    public ExpensePanel(String currentCategory){
        this.currentCategory = currentCategory;
        setMaximumSize(new Dimension(100,100));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //createLabels();
    }

    public String getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(String currentCategory) {
        this.currentCategory = currentCategory;
    }
}
