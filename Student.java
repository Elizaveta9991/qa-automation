import java.util.*;

public class Student {
    private String name;
    private String group;
    private int course;
    private Map<String, Integer> grades;

    public Student(String name, String group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new HashMap<>();
    }

    public void addGrade(String subject, int grade) {
        grades.put(subject, grade);
    }

    public double getAverageGrade() {
        if (grades.isEmpty())
            return 0.0;
        int sum = 0;
        for (int grade : grades.values()) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void transferToNextCourse() {
        if (getAverageGrade() >= 3.0) {
            course++;
        }
    }

    @Override
    public String toString() {
        return String.format("%s (группа: %s, курс: %d, средний балл: %.2f)", name, group, course, getAverageGrade());
    }

    public static void removeUnderperformingStudents(Set<Student> students) {
        java.util.Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3.0) {
                iterator.remove();
            }
        }
    }

    public static void transferToNextCourse(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3.0) {
                student.transferToNextCourse();
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты " + course + "-го курса:");
        boolean hasStudents = false;

        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("  - " + student.getName());
                hasStudents = true;
            }
        }

        if (!hasStudents) {
            System.out.println(" На этом курсе нет студентов.");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        Student student1 = new Student("Иван Иванов", "Группа А", 1);
        student1.addGrade("Математика", 4);
        student1.addGrade("Физика", 3);

        Student student2 = new Student("Мария Петрова", "Группа Б", 2);
        student2.addGrade("Математика", 2);
        student2.addGrade("Физика", 2);

        Student student3 = new Student("Алексей Сидоров", "Группа А", 1);
        student3.addGrade("Математика", 5);
        student3.addGrade("Физика", 4);

        students.add(student1);
        students.add(student2);
        students.add(student3);

        System.out.println("=== Исходный список всех студентов ===");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println();

        printStudents(students, 1);
        printStudents(students, 2);

        removeUnderperformingStudents(students);
        System.out.println("=== После удаления студентов с баллом < 3 ===");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println();

        transferToNextCourse(students);
        System.out.println("=== После перевода на следующий курс ===");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println();

        printStudents(students, 1);
        printStudents(students, 2);
        printStudents(students, 3);
    }
}