package SetsAndMapsAdvancedLab;

import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map <String, List <Double>> studentsMap = new TreeMap<>();


        while (n-- > 0) {
            String [] inputLine = scanner.nextLine().split(" ");
            String student = inputLine[0];
            double grade = Double.parseDouble(inputLine[1]);

            studentsMap.putIfAbsent(student, new ArrayList<>());
            List <Double> grades = studentsMap.get(student);
            grades.add(grade);
        }

        studentsMap.entrySet().stream().forEach(entry -> {
            System.out.print(entry.getKey() + " -> ");
            entry.getValue().forEach(innerEntry -> System.out.printf("%.2f ", innerEntry));
            double average = entry.getValue().stream().mapToDouble(e -> e).average().getAsDouble();
                System.out.printf("avg: 0.00)%n");

        });
    }
}
