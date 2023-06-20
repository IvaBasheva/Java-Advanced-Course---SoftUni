package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String [] kidsList = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque <String> kidsQueue = new ArrayDeque<>();

       Collections.addAll(kidsQueue, kidsList);

       while (kidsQueue.size() > 1) {
           for (int i = 1; i < n; i++) {
               String child = kidsQueue.poll();
               kidsQueue.offer(child);
           }
           System.out.println("Removed " + kidsQueue.poll());
       }
        System.out.println("Last is " + kidsQueue.peek());
    }
}
