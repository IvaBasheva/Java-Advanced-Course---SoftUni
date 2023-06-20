package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String command = scanner.nextLine();
        ArrayDeque <String> filesToPrint = new ArrayDeque<>();


        while (!command.equals("print")) {
            if (!command.equals("cancel")) {
                filesToPrint.offer(command);
            } else {
                if (!filesToPrint.isEmpty()) {
                    System.out.println("Canceled " + filesToPrint.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            }
            command = scanner.nextLine();
        }
        while (!filesToPrint.isEmpty()) {
            System.out.println(filesToPrint.poll());
        }
    }
}
