package com.example;

import javax.swing.*;
import java.awt.*;

public class TransactionsPanel extends JPanel {

    JLabel info = new JLabel("All transactions are showed here");

    public TransactionsPanel(){
        setLayout(new BorderLayout());
        info.setFont(new Font("Roboto", 1, 21));
        add(info);
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
}
