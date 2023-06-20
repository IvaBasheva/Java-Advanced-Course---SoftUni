package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque <String> lastStrings = new ArrayDeque<>();
        String currentString = "";
        lastStrings.push(currentString);

        for (int i = 1; i <= n; i++) {
            String [] input = scanner.nextLine().split(" ");
            String command  = input[0];

            switch (command) {
                case "1":
                    String stringToAppend =  input[1];
                    currentString += stringToAppend;
                    lastStrings.push(currentString);
                    break;

                case "2":
                    int elementsToRemove = Integer.parseInt(input [1]);
                    currentString = currentString.substring(0, currentString.length() - elementsToRemove);
                    lastStrings.push(currentString);
                    break;

                case "3":
                    int indexToPrint = Integer.parseInt(input [1]);
                    char symbol = currentString.charAt(indexToPrint - 1);
                    System.out.println(symbol);
                    break;

                case "4":
                    lastStrings.pop();
                    currentString = lastStrings.peek();
                    break;

            }
        }

    }
}
