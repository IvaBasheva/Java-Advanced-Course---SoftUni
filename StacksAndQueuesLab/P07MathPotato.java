package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String [] kidsList = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> kidsQueue = new ArrayDeque<>();

        Collections.addAll(kidsQueue, kidsList);

        int cycles = 1;
        while (kidsQueue.size() > 1) {
            for (int i = 1; i < n; i++) {
                String child = kidsQueue.poll();
                kidsQueue.offer(child);
            }
            if (!isPrime (cycles)) {
                System.out.println("Removed " + kidsQueue.poll());
            } else {
                System.out.println("Prime " + kidsQueue.peek());
            }
            cycles ++;
        }
        System.out.println("Last is " + kidsQueue.peek());
    }

    private static boolean isPrime(int number) {
        if (number == 1 ) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

