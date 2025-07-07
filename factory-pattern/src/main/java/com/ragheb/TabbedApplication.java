package com.ragheb;

import javax.swing.*;
import java.util.List;

public class TabbedApplication extends JFrame
{
    private final JTabbedPane tabbedPane;

    public TabbedApplication() {
        super("Extensible Tabbed Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        tabbedPane = new JTabbedPane();
        add(tabbedPane);

        loadComponents();
    }

    private void loadComponents() {
        List<TabComponent> components = ComponentFactory.createComponents();

        for (TabComponent component : components) {
            tabbedPane.addTab(component.getTitle(), component.getContent());
        }
    }
    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(() -> {
            TabbedApplication app = new TabbedApplication();
            app.setVisible(true);
        });
    }
}
