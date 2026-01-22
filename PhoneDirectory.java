import java.util.*;

public class PhoneDirectory {
    private Map<String, List<String>> directory;

    public PhoneDirectory() {
        directory = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        if (!directory.containsKey(lastName)) {
            directory.put(lastName, new ArrayList<>());
        }
        directory.get(lastName).add(phoneNumber);
    }

    public void get(String lastName) {
        if (directory.containsKey(lastName)) {
            System.out.println("Телефоны для фамилии \"" + lastName + "\":");
            for (String phone : directory.get(lastName)) {
                System.out.println("  - " + phone);
            }
        } else {
            System.out.println("Фамиля \"" + lastName + "\" не найдена в справочнике.");
        }
    }

    public static void main(String[] args) {
        PhoneDirectory directory = new PhoneDirectory();
        directory.add("Иванов", "+7-999-111-11-11");
        directory.add("Петров", "+7-999-222-22-22");
        directory.add("Иванов", "+7-999-333-33-33");
        directory.add("Сидоров", "+7-999-444-44-44");
        directory.add("Иванов", "+7-999-555-55-55");

        System.out.println("=== Поиск в телефонном справочнике ===");
        directory.get("Иванов");
        directory.get("Петров");
        directory.get("Кузнецов");
    }
}
