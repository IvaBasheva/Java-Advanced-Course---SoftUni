package MultidimensionalArraysExercises;

import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String [] dimensions = scanner.nextLine().split("\\s+");

        int r = Integer.parseInt(dimensions[0]);
        int c = Integer.parseInt(dimensions[1]);

        String [][] matrix = new String [r][c];

        for (int row = 0; row < r; row++) {
            String [] arr = scanner.nextLine().split("\\s+");
            for (int col = 0; col < c; col++) {
                matrix [row][col] = arr[col];
            }
        }
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String [] commandLine = input.split("\\s+");
            if (commandLine.length < 5) {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }
            String command = commandLine[0];

            int row1 = Integer.parseInt(commandLine[1]);
            int col1 = Integer.parseInt(commandLine[2]);
            int row2 = Integer.parseInt(commandLine[3]);
            int col2 = Integer.parseInt(commandLine[4]);


            if (isValidCommand(commandLine, command) && isValidIndex(matrix, r, c, row1, col1, row2, col2)) {

                String firsToReplace = matrix[row1][col1];
                String secondToReplace = matrix[row2][col2];
                matrix[row1][col1] = secondToReplace;
                matrix[row2][col2] = firsToReplace;

                for (int row = 0; row < r; row++) {
                    for (int col = 0; col < c; col++) {
                        System.out.print(matrix[row][col] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }
    }

    private static boolean isValidIndex(String[][] matrix, int r, int c, int row1, int col1, int row2, int col2) {
        if (row1 <= r && row1 >= 0 && col1 <= c && col1 >= 0
        && row2 <= r && row2 >= 0 && col2 <= c && col2 >= 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isValidCommand(String [] commandLine, String command) {
        if (command.equals("swap") && commandLine.length == 5) {
            return true;
        } else {
            return false;
        }
    }
}
