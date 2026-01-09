import java.util.ArrayList;
import java.util.List;

class Animal {
    private static int animalCount = 0;
    private String name;
    
    public Animal(String name) {
        this.name = name;
        animalCount++;
    }
    
    public String getName() {
        return name;
    }
    
    public void run(int distance) {}
    
    public void swim(int distance) {}
    
    public static int getAnimalCount() {
        return animalCount;
    }
}

class Dog extends Animal {
    private static int dogCount = 0;
    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MAX_SWIM_DISTANCE = 10;
    
    public Dog(String name) {
        super(name);
        dogCount++;
    }
    
    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(getName() + " пробежал " + distance + " м.");
        } else {
            System.out.println(getName() + " не может пробежать " + distance + " м. Максимум: " + MAX_RUN_DISTANCE + " м.");
        }
    }
    
    @Override
    public void swim(int distance) {
        if (distance <= MAX_SWIM_DISTANCE) {
            System.out.println(getName() + " проплыл " + distance + " м.");
        } else {
            System.out.println(getName() + " не может проплыть " + distance + " м. Максимум: " + MAX_SWIM_DISTANCE + " м.");
        }
    }
    
    public static int getDogCount() {
        return dogCount;
    }
}

class Cat extends Animal {
    private static int catCount = 0;
    private static final int MAX_RUN_DISTANCE = 200;
    private boolean isFull;
    
    public Cat(String name) {
        super(name);
        this.isFull = false;
        catCount++;
    }
    
    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(getName() + " пробежал " + distance + " м.");
        } else {
            System.out.println(getName() + " не может пробежать " + distance + " м. Максимум: " + MAX_RUN_DISTANCE + " м.");
        }
    }
    
    @Override
    public void swim(int distance) {
        System.out.println(getName() + " не умеет плавать!");
    }
    
    public void eatFromBowl(Bowl bowl, int amount) {
        if (bowl.decreaseFood(amount)) {
            this.isFull = true;
            System.out.println(getName() + " покушал и теперь сыт.");
        } else {
            System.out.println(getName() + " не стал кушать, так как в миске недостаточно еды.");
        }
    }
    
    public boolean isFull() {
        return isFull;
    }
    
    public static int getCatCount() {
        return catCount;
    }
}

class Bowl {
    private int foodAmount;
    
    public Bowl(int initialFood) {
        setFoodAmount(initialFood);
    }
    
    public int getFoodAmount() {
        return foodAmount;
    }
    
    public void setFoodAmount(int amount) {
        if (amount < 0) {
            System.out.println("Количество еды не может быть отрицательным!");
            this.foodAmount = 0;
        } else {
            this.foodAmount = amount;
        }
    }
    
    public void addFood(int amount) {
        if (amount > 0) {
            this.foodAmount += amount;
            System.out.println("В миску добавлено " + amount + " единиц еды. Теперь в миске: " + foodAmount + " еды.");
        } else {
            System.out.println("Нельзя добавить отрицательное количество еды!");
        }
    }
    
    public boolean decreaseFood(int amount) {
        if (amount <= foodAmount) {
            foodAmount -= amount;
            System.out.println("Из миски съедено " + amount + " единиц еды. Осталось: " + foodAmount);
            return true;
        } else {
            System.out.println("В миске недостаточно еды! Требуется: " + amount + ", доступно: " + foodAmount);
            return false;
        }
    }
    
    public void info() {
        System.out.println("В миске " + foodAmount + " единиц еды.");
    }
}

public class AnimalsProject {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Рекс");
        Dog dog2 = new Dog("Мухтар");
        Cat cat1 = new Cat("Зевс");
        Cat cat2 = new Cat("Маркиз");
        Cat cat3 = new Cat("Барсик");
        
        dog1.run(150);
        dog1.run(600);
        dog1.swim(5);
        dog1.swim(15);
        
        cat1.run(150);
        cat1.run(250);
        cat1.swim(10);
        
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Собак: " + Dog.getDogCount());
        System.out.println("Котов: " + Cat.getCatCount());
        
        Bowl bowl = new Bowl(30);
        bowl.info();
        
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Снежок"));
        cats.add(new Cat("Пушок"));
        cats.add(new Cat("Мурзик"));
        cats.add(new Cat("Рыжик"));
        
        int[] foodNeeded = {10, 15, 20, 5};
        
        for (int i = 0; i < cats.size(); i++) {
            cats.get(i).eatFromBowl(bowl, foodNeeded[i]);
        }
        
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " сыт: " + cat.isFull());
        }
        
        bowl.info();
        
        bowl.addFood(50);
        
        for (int i = 0; i < cats.size(); i++) {
            if (!cats.get(i).isFull()) {
                cats.get(i).eatFromBowl(bowl, foodNeeded[i]);
            }
        }
        
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " сыт: " + cat.isFull());
        }
        
        System.out.println("Всего животных создано: " + Animal.getAnimalCount());
        System.out.println("Собак создано: " + Dog.getDogCount());
        System.out.println("Котов создано: " + Cat.getCatCount());
    }
}