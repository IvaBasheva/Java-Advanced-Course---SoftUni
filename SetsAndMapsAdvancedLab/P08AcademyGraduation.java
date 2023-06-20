package SetsAndMapsAdvancedLab;

import java.text.DecimalFormat;
import java.util.*;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map <String, List <Double>> students = new TreeMap<>();

        while (n-- > 0) {
            String name = scanner.nextLine();
            double [] grades = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToDouble(Double ::parseDouble)
                    .toArray();

            students.putIfAbsent(name, new ArrayList<>());
            List <Double> studentsGrades = students.get(name);
            for (double garde : grades) {
                studentsGrades.add(garde);
            }
        }
        students.entrySet().stream().forEach(entry -> {
            double sum = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                sum += entry.getValue().get(i);
            }
            double averageSum = sum / entry.getValue().size();
            System.out.println(entry.getKey() + " is graduated with " + averageSum);;
             });

    }
}
