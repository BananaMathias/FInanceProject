package com.example;

public class Budget {

    private String category;
    private int maxBudget;
    private int currentLeft;

    public Budget(String category, int maxBudget){
        this.category = category;
        this.maxBudget = maxBudget;
        currentLeft = this.maxBudget;
    }

    public void addExpense(int amount){
        this.currentLeft -= amount;
    }
    public void resetBudget(){
        this.currentLeft = this.maxBudget;
    }

    public int getCurrentLeft() {
        return currentLeft;
    }
    //Reset budget for next month, maybe button does this and you get an overflow income from previous month?
}
