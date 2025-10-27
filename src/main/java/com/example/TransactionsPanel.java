package com.example;

import javax.swing.*;
import java.awt.*;

public class TransactionsPanel extends JPanel {

    JLabel info = new JLabel("All transactions are showed here");
    CategoryData categoryData;
    JScrollPane scrollPane;

    public TransactionsPanel(CategoryData categoryData){
        this.categoryData = categoryData;
        setLayout(new BorderLayout());
        info.setFont(new Font("Roboto", Font.BOLD, 21));
        add(info);
        createScrollPane();
    }

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

    private void createScrollPane(){
        JPanel expensePanel = new ExpensePanel(categoryData, "Food");
        scrollPane = new JScrollPane(expensePanel);
        scrollPane.setMaximumSize(new Dimension(400, 400));
        add(scrollPane, BorderLayout.CENTER);
    }
}
