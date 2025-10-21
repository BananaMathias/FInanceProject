package com.example;

public class Transaction {

    private int amount;
    private String note;
    private String date; //Maybe date class
    private String type;
    private String category;

    public Transaction(int amount, String note, String category, String type){
        this.amount = amount;
        this.note = note;
        //this.date = date;
        this.category = category;
        this.type = type;
    }

    @Override
    public String toString() {
        return ("category: " + this.category + ", amount: " + String.valueOf(this.amount) + ", note: " + this.note);
    }

    public int getAmount() {
        return amount;
    }

    public String getType(){
        return type;
    }

    public String getCategory() {
        return category;
    }

    public String getNote() {
        return note;
    }
}
