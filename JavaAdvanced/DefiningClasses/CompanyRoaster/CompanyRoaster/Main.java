package DefiningClasses.CompanyRoaster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Employee>> output = new HashMap<>();

        int lines = Integer.parseInt(reader.readLine());

        for (int i = 0; i < lines; i++) {
            String[] info = reader.readLine().split("\\s+");

            String name = info[0];
            double salary = Double.parseDouble(info[1]);
            String position = info[2];
            String department = info[3];

            Employee employee = new Employee(name, salary, position, department);

            if (info.length == 5) {
                if (Character.isDigit(info[4].charAt(0))) {
                    employee.setAge(Integer.parseInt(info[4]));
                } else {
                    employee.setEmail(info[4]);
                }
            } else if (info.length == 6) {
                employee.setEmail(info[4]);
                employee.setAge(Integer.parseInt(info[5]));
            }

            output.putIfAbsent(department, new ArrayList<>());
            output.get(department).add(employee);
        }

        Map.Entry<String, List<Employee>> highestAvgSalary = output.entrySet()
                .stream()
                .sorted((f, s) -> {
                    int result = 0;

                    if (s.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble() < f.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble())
                        result = -1;
                    else if (s.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble() > f.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble())
                        result = 1;

                    return result;
                }).findFirst()
                .get();

        System.out.println(String.format("Highest Average Salary: %s", highestAvgSalary.getKey()));
        highestAvgSalary.getValue()
                .stream()
                .sorted((f, s) -> Double.compare(s.getSalary(), f.getSalary()))
                .forEach(e -> System.out.println(String.format("%s %.2f %s %d", e.getName(),
                        e.getSalary(),
                        e.getEmail(),
                        e.getAge())));
    }
}