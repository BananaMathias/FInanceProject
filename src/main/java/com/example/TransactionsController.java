package com.example;

import java.util.ArrayList;
import java.util.Objects;

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
        for (Transaction transaction : categoryData.getCategory(expensePanel.getCurrentCategory()).getTransactions()) {
            System.out.println(transaction.getAmount());
            expensePanel.add(transaction.getTransactionCard());
        }
    }

    private void setupListeners(){
        transactionsPanel.getBudgetPanel().getCategoryOptions().addActionListener(e -> onSelectionListener());
        transactionsPanel.getBudgetPanel().getTransactionButton().addActionListener(e -> onTransactionsClickListener());
    }

    private void onTransactionsClickListener(){
        TransactionDialog transactionDialog = new TransactionDialog(categories);
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

    private void onSelectionListener(){
        String selectedCategory = (String) transactionsPanel.getBudgetPanel().getCategoryOptions().getSelectedItem();
        double budgetToDisplay = categoryData.getBudget(selectedCategory);
        transactionsPanel.getBudgetPanel().getBudgetLabel().setText(String.valueOf(budgetToDisplay));
        currentCategory = selectedCategory;
        expensePanel.setCurrentCategory(currentCategory);
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

    private Category getCategory(String type){

        for (int i = 0; i < categoryData.getCategories().toArray().length; i++){
            if (Objects.equals(categoryData.getCategories().get(i).getType(), type)){
                return categoryData.getCategories().get(i);
            }
        }
        return null;
    }

    public void updateCategories(){
        for (String category: categories){
            transactionsPanel.getBudgetPanel().getCategoryOptions().addItem(category);
        }
    }

}
