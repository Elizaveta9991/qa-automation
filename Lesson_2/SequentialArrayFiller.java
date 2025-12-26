public class SequentialArrayFiller {
    public static void main(String[] args) {
        int[] array = new int[100];
        
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }
}
