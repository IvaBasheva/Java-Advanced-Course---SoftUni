package DefiningClassesExercises.Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        Map <String, Person> personData = new HashMap<>();
        String command = scanner.nextLine();

        while (!command.equals("End")) {

            String [] parameters = command.split("\\s+");
            String name = parameters [0];
            if (!personData.containsKey(name)) {
                personData.put(name, new Person());
            }
            String enteredData = parameters[1];

            switch (enteredData) {
                case "company":
                    String companyName = parameters[2];
                    String department = parameters[3];
                    double salary = Double.parseDouble(parameters [4]);

                    Company company = new Company(companyName, department, salary);
                    personData.get(name).setCompany(company);
                    break;

                case "pokemon":
                    String pokemonName = parameters [2];
                    String pokemonType = parameters [3];

                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    personData.get(name).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = parameters [2];
                    String parentBirthday = parameters [3];

                    Parent parent = new Parent(parentName, parentBirthday);
                    personData.get(name).getParents().add(parent);
                break;
                case "children":
                    String childName = parameters [2];
                    String childBirthday = parameters [3];

                    Child child = new Child(childName, childBirthday);
                    personData.get(name).getChildren().add(child);
                    break;
                case "car":
                    String model = parameters [2];
                    int speed = Integer.parseInt(parameters [3]);

                    Car car = new Car(model, speed);
                    personData.get(name).setCar(car);
                    break;
            }

            command = scanner.nextLine();
        }
        String searchedPearson = scanner.nextLine();

        System.out.println(searchedPearson);

        Person person = personData.get(searchedPearson);

        System.out.println(person.toString());

    }
}
