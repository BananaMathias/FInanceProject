package com.example;

import java.util.ArrayList;

public class Category {

    private Budget budget;
    private String type;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public Category(String type, Budget budget){
        this.type = type;
        this.budget = budget;
        
    }

    public void addTransaction(Transaction transaction){
        if (transaction != null) {
            this.transactions.add(transaction);
            getBudget().addExpense(transaction.getAmount());
        }

    }
    public String getType(){
        return this.type;
    }
    public Budget getBudget(){
        return this.budget;
    }
    public ArrayList<Transaction> getTransactions(){
        return transactions;
    }

    @Override
    public String toString(){
        return type;
    }
}
