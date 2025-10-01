import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Design Patterns Demo ===");
            System.out.println("1. Observer Pattern (Behavioral)");
            System.out.println("2. Strategy Pattern (Behavioral)");
            System.out.println("3. Singleton Pattern (Creational)");
            System.out.println("4. Factory Method Pattern (Creational)");
            System.out.println("5. Adapter Pattern (Structural)");
            System.out.println("6. Decorator Pattern (Structural)");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> ObserverDemo.main(null);
                case 2 -> StrategyDemo.main(null);
                case 3 -> SingletonDemo.main(null);
                case 4 -> FactoryDemo.main(null);
                case 5 -> AdapterDemo.main(null);
                case 6 -> DecoratorDemo.main(null);
                case 0 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice, try again!");
            }
        }
    }
}