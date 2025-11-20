package com.example;

import javax.swing.*;
import java.awt.*;

public class TransactionsPanel extends JPanel {

    JLabel info = new JLabel("All transactions are showed here");
    CategoryData categoryData;
    JScrollPane scrollPane;
    ExpensePanel expensePanel;

    public TransactionsPanel(CategoryData categoryData){
        this.categoryData = categoryData;
        setLayout(new BorderLayout());
        info.setFont(new Font("Roboto", Font.BOLD, 21));
        add(info);
        add(new JLabel("Category:     Amount:    Description:"), BorderLayout.NORTH);
        createScrollPane();
    }
/*
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        // Calculate x position for center
        int stripeX = getWidth() / 2 - 2; // center of the panel
        int stripeWidth = 4;              // thickness of stripe
        // Draw the vertical stripe
        g.fillRect(stripeX, 0, stripeWidth, getHeight());
    }
    */


    private void createScrollPane(){
        expensePanel = new ExpensePanel(categoryData, "Food");
        scrollPane = new JScrollPane(expensePanel);
        scrollPane.setMaximumSize(new Dimension(100, 100));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPane, BorderLayout.WEST);
    }
}
