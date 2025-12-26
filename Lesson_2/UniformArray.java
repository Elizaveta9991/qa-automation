public class UniformArray {
    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }
    
    public static void main(String[] args) {
        int[] result = createArray(8, 7);
        
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
