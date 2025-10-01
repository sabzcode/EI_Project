# Project Overviews

This document outlines two separate Java projects: a demonstration of common design patterns and a Mars Rover simulation.

***

## Exercise 1: Java Design Patterns Demonstration

This project contains practical implementations of six fundamental Gang of Four (GoF) design patterns in Java. Each pattern is demonstrated through a unique, real-world use case to provide a clear understanding of its purpose and application. The project is structured around an interactive command-line menu that allows you to run each demonstration individually.

### How to Run
To compile and run this project, you will need a Java Development Kit (JDK) installed on your system.
1.  Clone the repository or download all the `.java` files into a single directory.
2.  Open a terminal or command prompt and navigate to that directory.
3.  Compile all the Java source files with the following command:
    ```bash
    javac *.java
    ```
4.  Run the main application menu:
    ```bash
    java MainMenu
    ```
5.  You will be presented with a menu to choose which design pattern demo you want to run.

### Patterns Implemented
The six patterns are categorized into their respective groups:

#### Creational Patterns
These patterns provide object creation mechanisms that increase flexibility and reuse of existing code.
* **Singleton Pattern**: Ensures a single, globally accessible system logger. The `Logger` class can only be instantiated once, and `getInstance()` always returns the same object reference. (Source: `SingletonDemo.java`)
* **Factory Method Pattern**: Decouples object creation by using a `ShapeFactory` to produce `Circle` or `Square` objects based on a string input. (Source: `FactoryDemo.java`)

#### Structural Patterns
These patterns explain how to assemble objects and classes into larger structures.
* **Adapter Pattern**: Makes an incompatible legacy component work with a modern system. A `PrinterAdapter` allows an `OldPrinter` to be used where a `NewPrinter` is expected. (Source: `AdapterDemo.java`)
* **Decorator Pattern**: Dynamically adds extras to a coffee order. A base `SimpleCoffee` object is "decorated" with `MilkDecorator` and `SugarDecorator`. (Source: `DecoratorDemo.java`)

#### Behavioral Patterns
These patterns are concerned with algorithms and the assignment of responsibilities between objects.
* **Observer Pattern**: Allows a `WeatherStation` to automatically notify multiple display devices (`PhoneDisplay`, `TVDisplay`) of temperature updates. (Source: `ObserverDemo.java`)
* **Strategy Pattern**: Enables a `ShoppingCart` to switch between different payment algorithms (`CreditCardPayment`, `PayPalPayment`) at runtime. (Source: `StrategyDemo.java`)

***

## Exercise 2: Mars Rover Simulation

This Java-based project simulates a rover navigating a grid on Mars. The rover can move, turn, avoid obstacles, and stay within boundaries. It can be operated via a Command Line Interface (CLI) or an HTML frontend.

### Key Features
* Grid-based navigation
* Obstacle detection and avoidance
* Command execution using behavioral patterns
* Logging and status reporting
* Dual interface: CLI and Web (Spring Boot + HTML)

### Architecture and Design Principles
The project is built on a foundation of strong OOP principles and design patterns.

#### Object-Oriented Programming
* **Encapsulation**: The `Rover` class encapsulates its own position and direction data.
* **Inheritance**: Command classes (`MoveCommand`, etc.) inherit from a common `Command` interface.
* **Polymorphism**: Commands are executed polymorphically on the rover through the `Command` interface.

#### Design Patterns
* **Command Pattern (Behavioral)**: Rover commands (M, L, R) are encapsulated as objects, providing flexibility.
* **Composite Pattern (Structural)**: The grid and obstacles are represented using a composite structure (`GridComposite`, `Obstacle`).

#### SOLID Principles
The architecture adheres to SOLID principles (Single Responsibility, Open/Closed, etc.).

### Key Components
| Component | Responsibility |
| :--- | :--- |
| **Rover** | Maintains position and direction; executes moves/turns; detects obstacles. |
| **GridComposite** | Represents the grid and manages obstacles; checks bounds. |
| **Obstacle** | A leaf component that represents an obstacle on the grid. |
| **Command Interface** | An abstract command pattern for all rover actions. |
| **Move/Left/RightCommand** | Concrete commands for moving and turning the rover. |
| **CommandFactory** | A factory to generate command objects from user input. |
| **RoverController** | A Spring Boot REST controller for the HTML frontend. |
| **MarsRoverCLI** | The CLI interface for running command-line simulations. |

### User Interfaces
The simulation can be controlled via two different interfaces.

#### HTML Frontend
* Provides input fields for Grid Size, Start Position, Obstacles, and Commands.
* A "Run Rover" button submits the data to a `/commands` endpoint.
* Displays the rover's final position and status.

#### Command Line Interface (CLI)
* Can be run with default values for the grid, obstacles, start, and commands.
* Provides a step-by-step log in the console, showing each move and turn.

### Example Scenarios

#### Scenario 1: Simple Movement
* **Input**: Grid 5x5, start at (0,0,N), obstacle at (2,2), commands "M,M,M".
* **Output**: The rover moves three steps north, finishing at **Position: (0, 3, N)** with **Status: Success**.

#### Scenario 2: Obstacle Encounter
* **Input**: Grid 5x5, start at (0,0,N), obstacle at (1,2), commands "M,M,R,M".
* **Output**: The rover moves north twice, turns right, but its next move is blocked. It finishes at **Position: (0, 2, E)** with **Status: Obstacle at (1,2)**.
