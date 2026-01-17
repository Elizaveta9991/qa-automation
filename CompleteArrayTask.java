class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    private int row;
    private int col;
    private String invalidValue;

    public MyArrayDataException(int row, int col, String invalidValue) {
        super(String.format("Неверные данные в [%d][%d]: '%s'", row, col, invalidValue));
        this.row = row;
        this.col = col;
        this.invalidValue = invalidValue;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String getInvalidValue() {
        return invalidValue;
    }
}

public class CompleteArrayTask {

    public static int processArray(String[][] array)
            throws MyArraySizeException, MyArrayDataException {

        if (array.length != 4) {
            throw new MyArraySizeException("Нужно 4 строки, получено: " + array.length);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null || array[i].length != 4) {
                throw new MyArraySizeException(
                        "Строка " + i + ": нужно 4 столбца, получено: " +
                                (array[i] == null ? "null" : array[i].length));
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, array[i][j]);
                }
            }
        }
        return sum;
    }

    public static void demonstrateArrayIndexException() {
        System.out.println("\n=== ЗАДАНИЕ 4: ArrayIndexOutOfBoundsException ===");
        int[] numbers = { 1, 2, 3, 4, 5 };
        System.out.println("Массив: [1, 2, 3, 4, 5] (индексы 0-4)");

        System.out.println("\n1. Попытка получить numbers[10]:");
        try {
            int value = numbers[10];
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано: " + e.getClass().getSimpleName());
            System.out.println("Сообщение: " + e.getMessage());
        }

        System.out.println("\n2. Попытка получить numbers[-1]:");
        try {
            int value = numbers[-1];
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано: " + e.getClass().getSimpleName());
            System.out.println("Сообщение: " + e.getMessage());
        }

        System.out.println("\n3. Цикл for до 10 (массив на 5 элементов):");
        try {
            for (int i = 0; i <= 10; i++) {
                System.out.println("numbers[" + i + "] = " + numbers[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано при i > 4: " + e.getMessage());
        }
    }

    private static void processAndPrint(String[][] array) {
        System.out.print("Массив: ");
        if (array == null) {
            System.out.println("null");
        } else {
            System.out.println(array.length + "x" +
                    (array.length > 0 && array[0] != null ? array[0].length : "?"));
        }

        try {
            int result = processArray(array);
            System.out.println("Успех: Сумма = " + result);
        } catch (MyArraySizeException e) {
            System.out.println("MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("MyArrayDataException: " + e.getMessage());
            System.out.println("   Место ошибки: строка " + e.getRow() + ", столбец " + e.getCol());
            System.out.println("   Неверное значение: '" + e.getInvalidValue() + "'");
        } catch (Exception e) {
            System.out.println("Неожиданная ошибка: " + e.getClass().getName());
            System.out.println("   Сообщение: " + e.getMessage());
        }
        System.out.println("---");
    }

    public static void main(String[] args) {
        System.out.println("=== ВЫПОЛНЕНИЕ ВСЕХ ЗАДАНИЙ ===\n");

        System.out.println("ТЕСТ 1: Правильный массив 4x4 с числами");
        String[][] test1 = {
                { "1", "2", "3", "4" },
                { "5", "6", "7", "8" },
                { "9", "10", "11", "12" },
                { "13", "14", "15", "16" }
        };
        processAndPrint(test1);

        System.out.println("\nТЕСТ 2: Массив с текстом вместо чисел");
        String[][] test2 = {
                { "1", "2", "3", "4" },
                { "5", "шесть", "7", "8" },
                { "9", "10", "11", "12" },
                { "13", "14", "15", "16" }
        };
        processAndPrint(test2);

        System.out.println("\nТЕСТ 3: Массив 3x4 (мало строк)");
        String[][] test3 = {
                { "1", "2", "3", "4" },
                { "5", "6", "7", "8" },
                { "9", "10", "11", "12" }
        };
        processAndPrint(test3);

        System.out.println("\nТЕСТ 4: Пустой массив");
        String[][] test4 = new String[0][0];
        processAndPrint(test4);

        demonstrateArrayIndexException();
        System.out.println("\n=== ПРОГРАММА ЗАВЕРШЕНА ===");
    }
}