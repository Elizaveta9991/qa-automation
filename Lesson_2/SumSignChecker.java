public class SumSignChecker {
    public static void checkSumSign() {
        int a = 30;
        int b = -20;
        int sum = a + b;
        
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
    
    public static void main(String[] args) {
        checkSumSign();
    }
}