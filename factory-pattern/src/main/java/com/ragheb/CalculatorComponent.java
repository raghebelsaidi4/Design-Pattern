package com.ragheb;

import javax.swing.*;
import java.awt.*;

public class CalculatorComponent implements TabComponent{
    @Override
    public String getTitle() {
        return "Calculator";
    }

    @Override
    public JPanel getContent() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5)); // 4 صفوف × 4 أعمدة مع فراغ بسيط

        panel.add(new JButton("7"));
        panel.add(new JButton("8"));
        panel.add(new JButton("9"));
        panel.add(new JButton("/"));

        panel.add(new JButton("4"));
        panel.add(new JButton("5"));
        panel.add(new JButton("6"));
        panel.add(new JButton("*"));

        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("-"));

        panel.add(new JButton("0"));
        panel.add(new JButton("."));
        panel.add(new JButton("="));
        panel.add(new JButton("+"));

        return panel;
    }
}
