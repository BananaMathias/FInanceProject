package com.example;

import java.util.ArrayList;

public class TransactionsController implements TransactionsObserver {

    private TransactionsPanel transactionsPanel;
    private MainWindow mainWindow;
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
        expensePanel = transactionsPanel.getExpensePanel();
        updateTransactions();
        transactionsPanel.getBudgetPanel().addComboBox(categories);
        updateCategories();
        setupListeners();
    }

    public void updateTransactions() {
        expensePanel.removeAll();
        for (Transaction transaction : categoryData.getCategory(expensePanel.currentCategory).getTransactions()) {
            System.out.println(transaction.getAmount());
            expensePanel.add(transaction.getTransactionCard());
        }
    }

    private void setupListeners(){
        transactionsPanel.getBudgetPanel().getCategoryOptions().addActionListener(e -> onSelectionListener());
    }

    private void onSelectionListener(){
        String selectedCategory = (String) transactionsPanel.getBudgetPanel().getCategoryOptions().getSelectedItem();
        double budgetToDisplay = categoryData.getBudget(selectedCategory);
        transactionsPanel.getBudgetPanel().getBudgetLabel().setText(String.valueOf(budgetToDisplay));
        currentCategory = selectedCategory;
        updateTransactions();
    }

    public void setCategories(ArrayList<String> array){
        categories = array;
    }

    public void setCurrentCategory(String category){
        if (category != null){
            currentCategory = category;
        }
    }

    public void updateCategories(){
        for (String category: categories){
            transactionsPanel.getBudgetPanel().getCategoryOptions().addItem(category);
        }
    }

}
