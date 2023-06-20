package DefiningClassesExercises.RawData;

import javax.naming.directory.InvalidSearchControlsException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List <Car> cars = new ArrayList<>();


        for (int i = 1; i <= n; i++) {
            List <Tire> tires = new ArrayList<>();
            String [] carInfo = scanner.nextLine().split("\\s+");

            String model = carInfo[0];
            int engineSpeed = Integer.parseInt(carInfo[1]);
            int enginePower = Integer.parseInt(carInfo[2]);
            int cargoWeight = Integer.parseInt(carInfo[3]);
            String cargoType = carInfo[4];
            double tire1Pressure = Double.parseDouble(carInfo [5]);
            int tire1Age = Integer.parseInt(carInfo [6]);
            double tire2Pressure = Double.parseDouble(carInfo [7]);
            int tire2Age = Integer.parseInt(carInfo [8]);
            double tire3Pressure = Double.parseDouble(carInfo [9]);
            int tire3Age = Integer.parseInt(carInfo [10]);
            double tire4Pressure = Double.parseDouble(carInfo [11]);
            int tire4Age = Integer.parseInt(carInfo [12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoType, cargoWeight);
            Tire tire1 = new Tire(tire1Age, tire1Pressure);
            Tire tire2 = new Tire(tire2Age, tire2Pressure);
            Tire tire3 = new Tire(tire3Age, tire3Pressure);
            Tire tire4 = new Tire(tire4Age, tire4Pressure);

            tires.add(tire1);
            tires.add(tire2);
            tires.add(tire3);
            tires.add(tire4);

            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);

        }
        String command = scanner.nextLine();
        List <Car> output = new ArrayList<>();
        switch (command) {
            case "fragile":
                List<Car> fragileCars = cars.stream().filter(car -> car.getCargo()
                                .getType().contains("fragile"))
                        .collect(Collectors.toList());

                fragileCars.stream().forEach(car -> {
                    for (Tire tire : car.getTires()) {
                        if (tire.getPressure() < 1) {
                            output.add(car);
                            break;
                        }
                    }
                });
                break;
            case "flamable":
                List<Car> flamableCars = cars.stream().filter(car -> car.getCargo()
                                .getType().contains("flamable"))
                        .collect(Collectors.toList());
                for (Car flamableCar : flamableCars) {
                    if (flamableCar.getEngine().getPower() > 250) {
                        output.add(flamableCar);
                    }
                }
                break;
        }
        for (Car car : output) {
            System.out.println(car.getModel());
        }

    }
}
