package com.example;


//import jdk.tools.jmod.Main;

import javax.swing.*;
public class Launcher {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CategoryData categoryData = new CategoryData();
                BudgetPanel budgetPanel = new BudgetPanel();
                TransactionsPanel transactionsPanel = new TransactionsPanel(categoryData);
                MainWindow main = new MainWindow(budgetPanel, transactionsPanel);
                TransactionsController transactionsController = new TransactionsController(transactionsPanel, main, categoryData);
                MainWindowController mainController = MainWindowController.getInstance(budgetPanel, main, categoryData, transactionsController);

                mainController.addTransactionsObs(transactionsController);
                main.show();
            }
        });
    }
}
