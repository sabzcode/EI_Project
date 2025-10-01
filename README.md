Exercise 1:
Java Design Patterns: A Practical Demonstration
This project contains practical implementations of six fundamental Gang of Four (GoF) design patterns in Java. Each pattern is demonstrated through a unique, real-world use case to provide a clear understanding of its purpose and application.

The project is structured around an interactive command-line menu that allows you to run each demonstration individually.

How to Run
To compile and run this project, you will need a Java Development Kit (JDK) installed on your system.

Clone the repository or download all the .java files into a single directory.

Open a terminal or command prompt and navigate to that directory.

Compile all the Java source files with the following command:

javac *.java
Run the main application menu:

java MainMenu
You will be presented with a menu to choose which design pattern demo you want to run.

Patterns Implemented
The six patterns are categorized into their respective groups: Creational, Structural, and Behavioral.

Creational Patterns
These patterns provide object creation mechanisms that increase flexibility and reuse of existing code.

Singleton Pattern

Use Case: Ensures a single, globally accessible system logger. This is demonstrated by the Logger class, which can only be instantiated once. No matter how many times getInstance() is called, it always returns the same object reference.

Source File: SingletonDemo.java

Factory Method Pattern

Use Case: Decouples object creation by using a factory to produce different shapes. The ShapeFactory class creates Circle or Square objects based on a string input, hiding the instantiation logic from the client.

Source File: FactoryDemo.java

Structural Patterns
These patterns explain how to assemble objects and classes into larger structures, while keeping these structures flexible and efficient.

Adapter Pattern

Use Case: Makes an incompatible legacy component work with a modern system. A PrinterAdapter allows an OldPrinter (with a printText method) to be used where a NewPrinter (with a printDocument method) is expected.

Source File: AdapterDemo.java

Decorator Pattern

Use Case: Dynamically adds extras to a coffee order. A base SimpleCoffee object is "decorated" with MilkDecorator and SugarDecorator to add new functionality (modifying cost and description) without altering the original class.

Source File: DecoratorDemo.java

Behavioral Patterns
These patterns are concerned with algorithms and the assignment of responsibilities between objects.

Observer Pattern

Use Case: Allows a central weather station to notify multiple display devices automatically. When the WeatherStation's temperature is updated, all registered observers (PhoneDisplay, TVDisplay) are notified and update themselves.

Source File: ObserverDemo.java

Strategy Pattern

Use Case: Enables an e-commerce shopping cart to switch between different payment algorithms at runtime. The ShoppingCart can be configured with a CreditCardPayment or PayPalPayment strategy to process an order without changing its own code.

Source File: StrategyDemo.java

Exercise 2:

Mars Rover Simulation 

Project Overview
The Mars Rover Simulation is a Java-based project that simulates a rover navigating a grid-based terrain on Mars. The rover is designed to move forward, turn left, or turn right while actively avoiding obstacles and staying within the predefined grid boundaries. The simulation can be operated through a Command Line Interface (CLI) or an HTML-based frontend.



Key Features
Grid-based navigation 

Obstacle detection and avoidance 

Command execution using behavioral patterns 

Logging and status reporting 

Dual interface: CLI and Web (Spring Boot + HTML) 

Architecture and Design Principles
The project is built upon a foundation of strong Object-Oriented principles and well-established design patterns to ensure scalability and maintainability.

Object-Oriented Programming 


Encapsulation: Each class is responsible for managing its own data and provides controlled access. For example, the 

Rover class encapsulates its own position and direction data.


Inheritance: Command classes such as MoveCommand, LeftCommand, and RightCommand inherit from a common Command interface.


Polymorphism: Commands are executed polymorphically on the rover through the common Command interface.

Design Patterns 


Command Pattern (Behavioral): Rover commands (M, L, R) are encapsulated as objects. This design provides flexibility in executing, extending, or scheduling commands.



Composite Pattern (Structural): The grid and its obstacles are represented using a composite structure, with components like GridComposite and Obstacle. This allows for a scalable and maintainable representation of the terrain and its obstacles.


SOLID Principles
The architecture adheres to SOLID principles, including Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, and Dependency Inversion.

Key Components
The following table outlines the core components of the simulation and their responsibilities.

Component	Responsibility
Rover	- Maintains position and direction; executes moves/turns; detects obstacles. 

GridComposite	- Represents the grid and manages obstacles; checks bounds. 

Obstacle	- A leaf component that represents an obstacle on the grid. 

Command Interface	- An abstract command pattern for all rover actions. 

MoveCommand, LeftCommand, RightCommand	- Concrete commands for moving and turning the rover. 

CommandFactory	- A factory to generate command objects from user input. 

RoverController	- A Spring Boot REST controller to handle requests from the HTML frontend. 

MarsRoverCLI	- The CLI interface for running command-line simulations. 

User Interfaces
The simulation can be controlled via two different interfaces.

HTML Frontend 

Provides input fields for 

Grid Size, Start Position, Obstacles, and Commands.

A "Run Rover" button submits the data to a 

/commands endpoint.

The interface displays the rover's final position and status after the simulation completes.

Command Line Interface (CLI) 

Can be run with default values for the grid, obstacles, start position, and commands.

Provides a step-by-step log in the console, showing each move, turn, and obstacle encountered.

Example Scenarios
Scenario 1: Simple Movement 


Input: Grid 5x5, start at (0,0,N), one obstacle at (2,2), and commands "M,M,M".


Output: The rover successfully moves three steps north, finishing at Final Position: (0, 3, N) with Status: Success.

Scenario 2: Obstacle Encounter 


Input: Grid 5x5, start at (0,0,N), one obstacle at (1,2), and commands "M,M,R,M".

Output: The rover moves north twice, turns right to face east, but its next move is blocked. It finishes at 

Final Position: (0, 2, E) with Status: Obstacle at (1,2).

Logging and Exception Handling
The system uses an 

SLF4J Logger within the Rover class to track all movements, turns, and obstacle encounters.

Exceptions:

ObstacleDetectedException: This is triggered when the rover would hit an obstacle. The event is logged, and the move is skipped.

OutOfBoundsException: This is triggered if the rover attempts to move outside the grid. The violation is logged, and the move is skipped.

Final status messages are returned to the user through the frontend or the CLI.
