public class Park {
    private String parkName;
    private String address;
    private String workingHours;
    public class Attraction {
        private String attractionName;
        private String attractionHours;
        private double price;
        public Attraction(String name, String hours, double price) {
            this.attractionName = name;
            this.attractionHours = hours;
            this.price = price;
        }
        public void printAttractionInfo() {
            System.out.println("Аттракцион: " + attractionName);
            System.out.println("Время работы: " + attractionHours);
            System.out.printf("Стоимость: %.2f руб\n", price);
        }
        public String getName() { return attractionName; }
        public double getPrice() { return price; }
    } 
    public Park(String parkName, String address, String workingHours) {
        this.parkName = parkName;
        this.address = address;
        this.workingHours = workingHours;
    }
    public void printParkInfo() {
        System.out.println("ПАРК: " + parkName);
        System.out.println("Адрес: " + address);
        System.out.println("Часы работы парка: " + workingHours);
    }
    public static void main(String[] args) {
        System.out.println("ЗАДАНИЕ 3: ПАРК С ВНУТРЕННИМ КЛАССОМ");
        Park centralPark = new Park("Центральный парк", "ул. Парковая, 1", "08:00 - 22:00");
        centralPark.printParkInfo();
        System.out.println("\nАТТРАКЦИОНЫ:");
        Park.Attraction carousel = centralPark.new Attraction("Карусель", "10:00 - 20:00", 150);
        Park.Attraction ferrisWheel = centralPark.new Attraction("Колесо обозрения", "11:00 - 21:00", 300);
        Park.Attraction rollerCoaster = centralPark.new Attraction("Американские горки", "12:00 - 19:00", 450);
        Park.Attraction hauntedHouse = centralPark.new Attraction("Дом с привидениями", "14:00 - 22:00", 250);
        carousel.printAttractionInfo();
        ferrisWheel.printAttractionInfo();
        rollerCoaster.printAttractionInfo();
        hauntedHouse.printAttractionInfo();
    }
}
