package com.example;

import javax.swing.*;
import java.util.ArrayList;

public class ButtonsPanel extends JPanel {
    /* Try reusing mainWindowPanel, rename in that case to something else,
       or make mainwindowpanel to something else and create a higher panel for main window
     */
    private JComboBox categoryOptions;

    public ButtonsPanel() {

    }

    public JComboBox addComboBox(ArrayList<String> categories) { // Might need to be added in transactionscontroller instead like mainController
        categoryOptions = new JComboBox(categories.toArray());
        //categoryOptions.setSelectedIndex(0);
        categoryOptions.setSize(100, 200);
        this.add(categoryOptions);
        return categoryOptions;
    }
}
