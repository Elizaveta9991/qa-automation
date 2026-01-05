public class Product {
    private String name;
    private String productionDate;
    private String manufacturer;
    private String country;
    private double price;
    private boolean isReserved;
public Product(String name, String productionDate, String manufacturer, String country, double price, boolean isReserved) {
    this.name = name;
    this.productionDate = productionDate;
    this.manufacturer = manufacturer;
    this.country = country;
    this.price = price;
    this.isReserved = isReserved;
}
public void printInfo() {
    System.out.println("=== ИНФОРМАЦИЯ О ТОВАРЕ ===");
    System.out.println("Название: " + name);
    System.out.println("Дата производства: " + productionDate);
    System.out.println("Производитель: " + manufacturer);
    System.out.println("Страна происхождения: " + country);
    System.out.printf("Цена: %.2f руб\n", price);
    System.out.println("Забронирован: " + (isReserved ? "Да" : "Нет"));   
}
public static void createProductArray(){
    System.out.println("\n=== ЗАДАНИЕ2: МАССИВ ИЗ 5 ТОВАРОВ ===");
    Product[] productsArray = new Product[5];
    productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
    productsArray[1] = new Product("Наушники Sony WH-1000XM5", "12.06.2000", "Sony Corporation", "Japan", 29999, false);
    productsArray[2] = new Product("Ноутбук HUAWEI MateBook D 16 MCLG-X", "01.01.2024", "Huawei ", "China", 58799, false);
    productsArray[3] = new Product("iPhone 17 Pro Max", "15.09.2025", "Apple Inc.", "USA", 152999, true);
    productsArray[4] = new Product("Планшет iPad Air (M3)", "08.11.2023", "Apple Inc.", "China", 59849, true);
    System.out.println("\nСписок всех товаров в массиве:");
    for (int i = 0; i < productsArray.length; i++)
        productsArray[i].printInfo();
    }
public static void main(String[] args) {
        Product laptop = new Product(
            "Ноутбук Huawei XPS 13",
            "24.03.2022",
            "Huawei Inc.",
            "Китай",
            45999.99,
            true
        );
        
        laptop.printInfo();
        
        Product phone = new Product(
            "iPhone 15 Pro",
            "01.12.2023",
            "Apple",
            "США",
            89999.50,
            false
        );
        
        phone.printInfo();
        createProductArray();
    }
}