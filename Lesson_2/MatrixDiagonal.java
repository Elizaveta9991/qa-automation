public class MatrixDiagonal {
     public static void main(String[] args) {
        int size = 5;
        int[][] matrix = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
        }
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
