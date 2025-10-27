package com.example;


//import jdk.tools.jmod.Main;

import javax.swing.*;
public class Launcher {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CategoryData categoryData = new CategoryData();
                MainWindowPanel mainWindowPanel = new MainWindowPanel();
                TransactionsPanel transactionsPanel = new TransactionsPanel(categoryData);
                MainWindow main = new MainWindow(mainWindowPanel, transactionsPanel);

                MainWindowController mainController = MainWindowController.getInstance(mainWindowPanel, main, categoryData);
                main.show();
            }
        });
    }
}
