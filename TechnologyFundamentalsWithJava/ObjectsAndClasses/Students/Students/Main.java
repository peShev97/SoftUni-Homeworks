package Students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentsCount = Integer.parseInt(scanner.nextLine());

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < studentsCount; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            Student student = new Student(input[0], input[1], Double.parseDouble(input[2]));

            students.add(student);
        }

        students = students.stream().sorted(Comparator.comparingDouble(Student::getGrade).reversed()).collect(Collectors.toList());

        for (Student item : students) {
            System.out.println(item);
        }
    }
}