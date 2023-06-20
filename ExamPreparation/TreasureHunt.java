package ExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    public static int currentRow = 0;
    public static int currentCol = 0;
    public static String direction;
    public  static List<String> previousDirections = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isFound = false;
        String[] dimensions = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String matrixRow = scanner.nextLine().replaceAll(" ", "");
            matrix[row] = matrixRow.toCharArray();
        }
        String command = scanner.nextLine();

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'Y') {
                    currentRow = r;
                    currentCol = c;
                    isFound = true;
                    break;
                }
                if (isFound) {
                    break;
                }
            }
        }

        while (!command.equals("Finish")) {
            direction = command;

            switch (direction) {
                case "up":
                    searchTreasure(matrix, currentRow - 1, currentCol);
                    break;
                case "down":
                    searchTreasure(matrix, currentRow + 1, currentCol);
                    break;
                case "left":
                    searchTreasure(matrix, currentRow, currentCol - 1);
                    break;
                case "right":
                    searchTreasure(matrix, currentRow, currentCol + 1);
                    break;
            }
            command = scanner.nextLine();
        }
        if (matrix[currentRow][currentCol] == 'X') {
            System.out.println("I've found the treasure!");
            System.out.print("The right path is ");
            System.out.print(previousDirections.toString().replaceAll("\\[", "")
                    .replaceAll("]", ""));
        } else {
            System.out.println("The map is fake!");
        }
    }

    private static void searchTreasure(char[][] matrix, int nextRow, int nextCol) {

        if (isOutOfBounds(matrix, nextRow, nextCol)) {
            if (nextRow < 0) {
                nextRow = 0;
            } else if (nextRow >= matrix.length) {
                nextRow = matrix.length - 1;
            } else if (nextCol < 0) {
                nextCol = 0;
            } else if (nextCol >= matrix[nextRow].length) {
                nextCol = matrix[nextRow].length - 1;
            }
        } else {
            previousDirections.add(direction);
        }
        if (matrix[nextRow][nextCol] == '-' || matrix[nextRow][nextCol] == 'X') {
            currentRow = nextRow;
            currentCol = nextCol;
        }
    }

    private static boolean isOutOfBounds(char[][] matrix, int r, int c) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }
}

