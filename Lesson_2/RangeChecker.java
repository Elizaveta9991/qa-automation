public class RangeChecker {
    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("5 + 6 = " + isSumInRange(5, 6));
        System.out.println("10 + 5 = " + isSumInRange(10, 5));
    }
}
