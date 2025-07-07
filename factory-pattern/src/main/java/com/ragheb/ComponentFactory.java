package com.ragheb;

import java.util.ArrayList;
import java.util.List;

public class ComponentFactory {
    private static final List<TabComponent> components = new ArrayList<>();

    static {
        // Register known components directly (instances)
        registerComponent(new WelcomeComponent());
        registerComponent(new CalculatorComponent());
    }
    public static void registerComponent(TabComponent component) {
        components.add(component);
    }

    public static List<TabComponent> createComponents() {
        return new ArrayList<>(components); // Return a copy to prevent external modification
    }
}

//          ## How to Extend with New Components
//
//          To add a new component without modifying the existing code:
//          1. Create a new class implementing `TabComponent`
//          2. Register it with the factory (or use classpath scanning in a more advanced solution)
//
//// Example of a new component
//    class WeatherComponent implements TabComponent {
//    @Override
//    public String getTitle() {
//        return "Weather";
//    }
//
//    @Override
//    public JPanel getContent() {
//        JPanel panel = new JPanel();
//        panel.add(new JLabel("Weather information will be displayed here"));
//        return panel;
//    }
//}
//// Register the new component (could be done via configuration file or classpath scanning)
//class ComponentFactory {
//    static {
//        registerComponent(WelcomeComponent.class);
//        registerComponent(CalculatorComponent.class);
//        registerComponent(WeatherComponent.class); // New component added
//    }
//    // ... rest of the factory code
//}




