package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OSPlaning {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        ArrayDeque <Integer> tasksStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(tasksStack::push);

        ArrayDeque <Integer> treadQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int endTask = Integer.parseInt(scanner.nextLine());

        int task = tasksStack.peek();
        int tread = treadQueue.peek();

        while (task != endTask) {

            if (tread >= task) {
                tasksStack.pop();
            }

            treadQueue.poll();



            task = tasksStack.peek();
            tread = treadQueue.peek();
        }
        System.out.printf("Thread with value %d killed task %d%n", treadQueue.peek(), endTask);

        String leftTreads = treadQueue.stream().map(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(leftTreads);
    }
}
