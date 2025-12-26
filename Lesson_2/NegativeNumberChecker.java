public class NegativeNumberChecker {
    public static boolean isNegative(int number) {
        return number < 0;
    }
    
    public static void main(String[] args) {
        System.out.println("10 is negative: " + isNegative(10));
        System.out.println("-5 is negative: " + isNegative(-5));
        System.out.println("0 is negative: " + isNegative(0));
    }
}

