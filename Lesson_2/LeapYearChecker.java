public class LeapYearChecker {
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return year % 4 == 0;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("2020 is leap: " + isLeapYear(2020));
        System.out.println("1900 is leap: " + isLeapYear(1900));
        System.out.println("2000 is leap: " + isLeapYear(2000));
        System.out.println("2023 is leap: " + isLeapYear(2023));
    }
}
