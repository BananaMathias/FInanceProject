package com.example;

import javax.swing.*;
import java.awt.*;

public class TransactionDialog extends JDialog {

    JComboBox categoryOptions;
    String[] categories;
    SpinnerNumberModel addAmountModel;
    JSpinner addAmountSpinner;
    JTextField note;
    JButton submitButton;
    JComboBox typeOptions;
    JLabel info = new JLabel("Create a new transaction");

    public TransactionDialog(String[] categories) {
        this.categories = categories;
        setSize(400, 500);
        info.setSize(300,60);
        info.setFont(new Font("Times new roman", Font.PLAIN, 21));
        this.add(info);
        this.add(Box.createVerticalStrut(50));
        createInfoLabel("Choose what type of transaction");
        addTypeComboBox();
        createInfoLabel("Choose transaction category");
        addComboBox();
        createInfoLabel("Add the transaction amount");
        addAmount();
        createInfoLabel("Add a note");
        addNote();
        this.add(Box.createVerticalStrut(50));
        addSubmitButton();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setLocationRelativeTo(null);
    }

    private void addTypeComboBox(){
        typeOptions = new JComboBox(new String[]{"EXPENSE", "INCOME"});
        typeOptions.setSelectedIndex(0);
        Dimension dimension = new Dimension(100,25);
        typeOptions.setMaximumSize(dimension);
        this.add(typeOptions);
        add(Box.createVerticalStrut(30));
    }

    private void addComboBox() {
        categoryOptions = new JComboBox(categories);
        categoryOptions.setSelectedIndex(0);
        Dimension dimension = new Dimension(150,25);
        categoryOptions.setAlignmentX(Component.CENTER_ALIGNMENT);
        categoryOptions.setMaximumSize(dimension);
        this.add(categoryOptions);
        add(Box.createVerticalStrut(30));
    }

    private void addAmount(){
        int defaultValue = 1000;
        addAmountModel = new SpinnerNumberModel(defaultValue, 0, 999999, 100);
        addAmountSpinner = new JSpinner(addAmountModel);
        addAmountSpinner.setAlignmentX(Component.CENTER_ALIGNMENT);
        Dimension dimension = new Dimension(75,25);
        addAmountSpinner.setMaximumSize(dimension);
        this.add(addAmountSpinner);
        add(Box.createVerticalStrut(30));
    }

    private void addNote(){
        note = new JTextField();
        Dimension dimension = new Dimension(250,50);
        note.setAlignmentX(Component.CENTER_ALIGNMENT);
        note.setMaximumSize(dimension);
        this.add(note);
    }

    private JLabel infoLabel(String message){
        return new JLabel(message);
    }

    private void createInfoLabel(String message){
        this.add(infoLabel(message));
        this.add(Box.createVerticalStrut(10));
    }

    private void addSubmitButton(){
        submitButton = new JButton("Create transaction");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(submitButton);
    }

    public JComboBox getCategoryOptions() {
        return categoryOptions;
    }

    public JSpinner getAddAmountSpinner() {
        return addAmountSpinner;
    }

    public JTextField getNote() {
        return note;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JComboBox getTypeOptions(){
        return typeOptions;
    }
}
