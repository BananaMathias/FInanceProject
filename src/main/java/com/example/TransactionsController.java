package com.example;

import java.util.ArrayList;

public class TransactionsController implements TransactionsObserver {

    private TransactionsPanel transactionsPanel;
    private MainWindow mainWindow;
    private MainWindowController mainWindowController;
    private CategoryData categoryData;
    private ExpensePanel expensePanel;
    private ArrayList<String> categories = new ArrayList<String>();
    private String currentCategory;

    public TransactionsController(
            TransactionsPanel transactionsPanel,
            MainWindow mainWindow,
            CategoryData categoryData) {

        this.transactionsPanel = transactionsPanel;
        this.mainWindow = mainWindow;
        this.categoryData = categoryData;
        expensePanel = transactionsPanel.expensePanel;
        updateTransactions();
    }

    public void updateTransactions() {
        expensePanel.removeAll();
        for (Transaction transaction : categoryData.getCategory(expensePanel.currentCategory).getTransactions()) {
            System.out.println(transaction.getAmount());
            expensePanel.add(transaction.getTransactionCard());
        }
    }

    public void setCategories(ArrayList<String> array){
        categories = array;
    }

    public void setCurrentCategory(String category){
        if (category != null){
            currentCategory = category;
        }
    }
}
