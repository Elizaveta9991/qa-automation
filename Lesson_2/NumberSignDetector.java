public class NumberSignDetector {
    public static void checkNumberSign(int number) {
        if (number >= 0) {
            System.out.println(number + " - положительное число");
        } else {
            System.out.println(number + " - отрицательное число");
        }
    }
    
    public static void main(String[] args) {
        checkNumberSign(10);
        checkNumberSign(-5);
        checkNumberSign(0);
    }
}

