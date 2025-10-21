package com.example;


//import jdk.tools.jmod.Main;

import javax.swing.*;
public class Launcher {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindowPanel mainWindowPanel = new MainWindowPanel();
                TransactionsPanel transactionsPanel = new TransactionsPanel();
                MainWindow main = new MainWindow(mainWindowPanel, transactionsPanel);
                MainWindowController mainController = MainWindowController.getInstance(mainWindowPanel, main);
                main.show();
            }
        });
    }
}
