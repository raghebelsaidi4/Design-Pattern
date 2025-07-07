# Factory Pattern in Java

The Factory Pattern is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.

## Types of Factory Patterns

1. **Simple Factory** (Not an official GoF pattern, but commonly used)
2. **Factory Method Pattern**
3. **Abstract Factory Pattern**

## 1. Simple Factory Example

```java
interface Animal {
    void speak();
}

class Dog implements Animal {
    @Override
    public void speak() {
        System.out.println("Woof!");
    }
}

class Cat implements Animal {
    @Override
    public void speak() {
        System.out.println("Meow!");
    }
}

class AnimalFactory {
    public Animal createAnimal(String type) {
        if ("dog".equalsIgnoreCase(type)) {
            return new Dog();
        } else if ("cat".equalsIgnoreCase(type)) {
            return new Cat();
        }
        return null;
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        AnimalFactory factory = new AnimalFactory();
        
        Animal dog = factory.createAnimal("dog");
        dog.speak(); // Output: Woof!
        
        Animal cat = factory.createAnimal("cat");
        cat.speak(); // Output: Meow!
    }
}
```

## 2. Factory Method Pattern

```java
abstract class Animal {
    public abstract void speak();
    
    // Factory method
    public static Animal create(String type) {
        if ("dog".equalsIgnoreCase(type)) {
            return new Dog();
        } else if ("cat".equalsIgnoreCase(type)) {
            return new Cat();
        }
        throw new IllegalArgumentException("Unknown animal type");
    }
}

class Dog extends Animal {
    @Override
    public void speak() {
        System.out.println("Woof!");
    }
}

class Cat extends Animal {
    @Override
    public void speak() {
        System.out.println("Meow!");
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        Animal dog = Animal.create("dog");
        dog.speak(); // Output: Woof!
        
        Animal cat = Animal.create("cat");
        cat.speak(); // Output: Meow!
    }
}
```

## 3. Abstract Factory Pattern

```java
// Abstract products
interface Button {
    void render();
}

interface Checkbox {
    void render();
}

// Concrete products for Windows
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a Windows button");
    }
}

class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a Windows checkbox");
    }
}

// Concrete products for Mac
class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a Mac button");
    }
}

class MacCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a Mac checkbox");
    }
}

// Abstract factory
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete factories
class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
    
    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }
    
    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

// Client code
class Application {
    private Button button;
    private Checkbox checkbox;
    
    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }
    
    public void render() {
        button.render();
        checkbox.render();
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        // Create a Windows application
        Application windowsApp = new Application(new WindowsFactory());
        windowsApp.render();
        
        // Create a Mac application
        Application macApp = new Application(new MacFactory());
        macApp.render();
    }
}
```

## Benefits of Factory Pattern

1. **Loose Coupling**: Client code doesn't need to know about concrete classes
2. **Single Responsibility Principle**: Object creation code is centralized
3. **Open/Closed Principle**: New types can be introduced without modifying existing code
4. **Improved Testability**: Easier to mock objects in tests

## When to Use

- When you don't know beforehand the exact types and dependencies of the objects your code should work with
- When you want to provide a way to extend the internal components of your code
- When you want to centralize the object creation logic
- When you want to reuse existing objects instead of creating new ones (similar to Flyweight pattern)