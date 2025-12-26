public class StringRepeater {
    public static void printStringMultipleTimes(String text, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }
    
    public static void main(String[] args) {
        printStringMultipleTimes("Hello Java!", 3);
    }
}
