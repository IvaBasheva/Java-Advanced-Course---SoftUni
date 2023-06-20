package DefiningClassesExercises.CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        boolean hasDigit;
        List<Engine> engineList = new ArrayList<>();



        for (int i = 1; i <= n; i++) {
            String [] engineInfo = scanner.nextLine().split("\\s+");

            String model = engineInfo[0];
            String power = engineInfo[1];
            String displacement = "n/a";
            String efficiency = "n/a";

            if (engineInfo.length == 3) {
                String currentInfo = engineInfo [2];
                hasDigit = checkForNumbers(currentInfo);

                if (hasDigit) {
                    displacement = currentInfo;
                } else {
                    efficiency = currentInfo;
                }
            } else if (engineInfo.length == 4) {
                displacement = engineInfo [2];
                efficiency = engineInfo [3];
            }
            Engine engine = new Engine(model, power, displacement, efficiency);
            engineList.add(engine);
        }
        int m = Integer.parseInt(scanner.nextLine());
        List <Car> carList = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            String [] carInfo = scanner.nextLine().split("\\s+");

            String model  = carInfo[0];
            String engine = carInfo[1];
            String weight = "n/a";
            String color = "n/a";

            if (carInfo.length == 3) {
                String currentData = carInfo [2];
                hasDigit = checkForNumbers(currentData);
                if (hasDigit) {
                    weight = currentData;
                } else {
                    color = currentData;
                }
            } else if (carInfo.length == 4) {
                weight = carInfo[2];
                color = carInfo[3];
            }
            for (Engine currentEngine : engineList) {
                if (currentEngine.getModel().contains(engine)) {
                    Engine neededEngine = new Engine(currentEngine.getModel(), currentEngine.getPower(),
                            currentEngine.getDisplacement(), currentEngine.getEfficiency());
                    Car car = new Car(model, neededEngine, weight, color);
                    carList.add(car);
                }
            }

        }
       carList.stream().forEach(c -> System.out.println(String.format("%s:" + "\n" + "%s:\n" +
                       "Power: %s\n" +
                       "Displacement: %s\n" +
                       "Efficiency: %s\n" +
                       "Weight: %s\n" +
                       "Color: %s", c.getModel(), c.getEngine().getModel(),
               c.getEngine().getPower(), c.getEngine().getDisplacement(), c.getEngine().getEfficiency(),
               c.getWeight(), c.getColor())));
    }
    private static boolean checkForNumbers(String currentInfo) {
        for (int i = 0; i < currentInfo.length(); i++) {
            int ascii = currentInfo.charAt(i);
            if (ascii > 47 && ascii < 58) {
                return true;
            }
        }
        return false;
    }
}
