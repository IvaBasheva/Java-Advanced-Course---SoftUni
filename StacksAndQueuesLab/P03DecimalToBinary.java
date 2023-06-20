package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque <Integer> binaryNumber = new ArrayDeque<>();

        if (number == 0) {
            System.out.println(number);
        }
        while (number != 0) {
            binaryNumber.push(number % 2);
            number = number / 2;
        }
        while (!binaryNumber.isEmpty()) {
            System.out.print(binaryNumber.pop());
        }
    }
}
