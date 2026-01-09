import java.util.ArrayList;
import java.util.List;

interface Colorable {
    void setFillColor(String color);

    void setBorderColor(String color);

    String getFillColor();

    String getBorderColor();
}

interface Shape extends Colorable {
    double calculateArea();

    double calculatePerimeter();

    default void displayInfo() {
        System.out.println(this);
    }

    default String getBasicInfo() {
        return String.format("Площадь: %.2f | Периметр: %.2f | Цвет: %s | Граница: %s", calculateArea(),
                calculatePerimeter(), getFillColor(), getBorderColor());
    }
}

class Circle implements Shape {
    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius) {
        this.radius = radius;
        this.fillColor = "Белый";
        this.borderColor = "Черный";
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void setFillColor(String color) {
        this.fillColor = color;
    }

    @Override
    public void setBorderColor(String color) {
        this.borderColor = color;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public String toString() {
        return String.format("Круг (радиус: %.1f)%n  %s", radius, getBasicInfo());
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        this.fillColor = "Белый";
        this.borderColor = "Черный";
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public void setFillColor(String color) {
        this.fillColor = color;
    }

    @Override
    public void setBorderColor(String color) {
        this.borderColor = color;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public String toString() {
        return String.format("Прямоугольник (%.1f x %.1f)%n  %s", width, height, getBasicInfo());
    }
}

class Triangle implements Shape {
    private double sideA;
    private double sideB;
    private double sideC;
    private String fillColor;
    private String borderColor;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = "Белый";
        this.borderColor = "Черный";

        if (!isValidTriangle()) {
            throw new IllegalArgumentException("Треугольник с такими сторонами не существует");
        }
    }

    private boolean isValidTriangle() {
        return (sideA + sideB > sideC) && (sideA + sideC > sideB) && (sideB + sideC > sideA);
    }

    @Override
    public double calculateArea() {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public void setFillColor(String color) {
        this.fillColor = color;
    }

    @Override
    public void setBorderColor(String color) {
        this.borderColor = color;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public String toString() {
        return String.format("Треугольник (%.1f, %.1f, %.1f)%n  %s", sideA, sideB, sideC, getBasicInfo());
    }
}

public class GeometryShapes {
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════");
        System.out.println("       РАСЧЕТ ПАРАМЕТРОВ ГЕОМЕТРИЧЕСКИХ ФИГУР");
        System.out.println("═══════════════════════════════════════════════\n");

        List<Shape> shapes = new ArrayList<>();

        Circle circle = new Circle(5.0);
        circle.setFillColor("Красный");
        circle.setBorderColor("Синий");
        shapes.add(circle);

        Rectangle rectangle = new Rectangle(4.0, 6.0);
        rectangle.setFillColor("Желтый");
        rectangle.setBorderColor("Фиолетовый");
        shapes.add(rectangle);

        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        triangle.setFillColor("Зеленый");
        triangle.setBorderColor("Оранжевый");
        shapes.add(triangle);

        System.out.println("ИНФОРМАЦИЯ О ФИГУРАХ:\n");
        for (int i = 0; i < shapes.size(); i++) {
            System.out.println((i + 1) + ". " + shapes.get(i));
            System.out.println();
        }

        System.out.println("СВОДНАЯ ТАБЛИЦА:");
        printSummaryTable(shapes);

        System.out.println("\n═══════════════════════════════════════════════");
        System.out.println("         ПРОГРАММА УСПЕШНО ВЫПОЛНЕНА");
        System.out.println("═══════════════════════════════════════════════");
    }

    private static void printSummaryTable(List<Shape> shapes) {
        System.out.println("┌──────────────┬──────────┬──────────┬────────────────┬────────────────┐");
        System.out.println("│   Фигура     │ Площадь  │ Периметр │  Цвет заливки  │ Цвет границы   │");
        System.out.println("├──────────────┼──────────┼──────────┼────────────────┼────────────────┤");

        for (Shape shape : shapes) {
            String figureName = shape.getClass().getSimpleName();
            String area = String.format("%.2f", shape.calculateArea());
            String perimeter = String.format("%.2f", shape.calculatePerimeter());

            System.out.printf("│ %-12s │ %-8s │ %-8s │ %-14s │ %-14s │%n",
                    figureName, area, perimeter,
                    shape.getFillColor(),
                    shape.getBorderColor());
        }

        System.out.println("└──────────────┴──────────┴──────────┴────────────────┴────────────────┘");
    }
}
