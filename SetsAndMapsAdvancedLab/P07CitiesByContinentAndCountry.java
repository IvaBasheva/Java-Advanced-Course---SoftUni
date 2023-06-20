package SetsAndMapsAdvancedLab;

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map <String, Map <String, List <String>>> continents = new LinkedHashMap<>();

        while (n-- >0) {
            String [] information = scanner.nextLine().split("\\s");

            String continent = information[0];
            String country = information[1];
            String city = information[2];

            continents.putIfAbsent(continent, new LinkedHashMap<>());
            Map <String, List <String>> countries = continents.get(continent);
            countries.putIfAbsent(country, new ArrayList<>());
            List <String> cities = countries.get(country);
            cities.add(city);
        }

        continents.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + ":");
            entry.getValue().entrySet().stream().forEach(innerEntry -> {
               String cities = String.join(", ", innerEntry.getValue());
                System.out.printf("%s -> %s%n",innerEntry.getKey(), cities);
                });
            });

    }

}
