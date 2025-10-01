interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() { System.out.println("[Circle] Drawing a Circle"); }
}

class Square implements Shape {
    public void draw() { System.out.println("[Square] Drawing a Square"); }
}

class ShapeFactory {
    public static Shape createShape(String type) {
        if (type.equalsIgnoreCase("circle")) return new Circle();
        else if (type.equalsIgnoreCase("square")) return new Square();
        throw new IllegalArgumentException("Unknown Shape: " + type);
    }
}

public class FactoryDemo {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.createShape("circle");
        circle.draw();

        Shape square = ShapeFactory.createShape("square");
        square.draw();
    }
}