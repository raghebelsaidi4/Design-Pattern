package com.ragheb;

import javax.swing.*;

public class WelcomeComponent implements TabComponent{
    @Override
    public String getTitle() {
        return "Welcome";
    }

    @Override
    public JPanel getContent() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Welcome to our application!"));
        return panel;
    }
}
