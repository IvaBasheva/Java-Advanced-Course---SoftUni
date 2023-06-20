package SetsAndMapsAdvancedLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String input = scanner.nextLine();

        Map <String, Map <String, Double>> shopsMap = new TreeMap<>();

        while (!input.equals("Revision")) {
            String [] information = input.split(", ");

            String shop = information [0];
            String product = information [1];
            double price = Double.parseDouble(information [2]);

            shopsMap.putIfAbsent(shop, new LinkedHashMap<>());
            Map <String, Double> productInfo = shopsMap.get(shop);
            productInfo.putIfAbsent(product, price);

            input = scanner.nextLine();
        }

        shopsMap.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + "->");
            entry.getValue().entrySet().stream().forEach(innerEntry -> {
                System.out.printf("Product: %s, Price: %.1f%n", innerEntry.getKey(), innerEntry.getValue());
            });
        });
    }

}
