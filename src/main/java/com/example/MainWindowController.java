package com.example;

import java.util.Objects;

public class MainWindowController {

    private static MainWindowController instance = null;
    private MainWindowPanel mainWindowPanel;
    private CategoryData categoryData;
    private MainWindow mainWindow;

    private MainWindowController(MainWindowPanel mainWindowPanel, MainWindow mainWindow, CategoryData categoryData){
        this.mainWindowPanel = mainWindowPanel;
        this.mainWindow = mainWindow;
        this.categoryData = categoryData;
        setupListeners();
        onSelectionListener(); // Updates the JComboBox to show the currentLeft of the startup category selected
    }

    public static MainWindowController getInstance(MainWindowPanel mainWindowPanel, MainWindow mainWindow, CategoryData categoryData){
        if (instance == null){
            instance = new MainWindowController(mainWindowPanel, mainWindow, categoryData);
        }
        return instance;
    }

    private void setupListeners(){
        mainWindowPanel.getCategoryOptions().addActionListener(e -> onSelectionListener());
        mainWindowPanel.getTransactionButton().addActionListener(e -> onTransactionClickListener());

    }

    private void onSelectionListener(){
        String selectedCategory = (String) mainWindowPanel.getCategoryOptions().getSelectedItem();
        selectedCategory.toUpperCase();
        double budgetToDisplay = categoryData.getBudget(selectedCategory);
        mainWindowPanel.getBudgetLabel().setText(String.valueOf(budgetToDisplay));
        //System.out.println(mainWindowPanel.getBudgetLabel().getText());
    }

    private void onTransactionClickListener(){
        TransactionDialog transactionDialog = new TransactionDialog(mainWindowPanel.getCategories());

        transactionDialog.getSubmitButton().addActionListener(e -> onSubmitListener(transactionDialog));

        transactionDialog.setModal(true);
        transactionDialog.setVisible(true);
    }

    private void onSubmitListener(TransactionDialog dialog){
        int amount = (int) dialog.getAddAmountSpinner().getValue();
        String category = (String) dialog.getCategoryOptions().getSelectedItem();
        String note = dialog.getNote().getText();
        String type = (String) dialog.getTypeOptions().getSelectedItem();

        Transaction transaction = new Transaction(amount, note, category, type);
        if (getCategory(category) != null){
            getCategory(category).addTransaction(transaction);
        }
        //System.out.println(transaction.toString());
        dialog.dispose();
        onSelectionListener(); // Update the JComboBox to show the updated currentLeft in the categories to update the currently selected category
    }

    private Category getCategory(String type){

        for (int i = 0; i < categoryData.getCategories().toArray().length; i++){
            if (Objects.equals(categoryData.getCategories().get(i).getType(), type)){
                return categoryData.getCategories().get(i);
            }
        }
        return null;
    }
}
