package ExamPreparation;

import java.util.Scanner;

public class ReVolt {
    public static int playerRow;
    public static int playerCol;
    public static boolean hasWon = false;

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        char [][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            String matrixRow = scanner.nextLine();
            matrix [row] = matrixRow.toCharArray();

            if (matrixRow.contains("f")) {
                playerRow = row;
                playerCol = matrixRow.indexOf("f");
            }
        }

        for (int i = 1; i <= numberOfCommands; i++) {
            if (hasWon) {
                break;
            }
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    movePlayer(matrix, playerRow - 1, playerCol);
                    break;
                case "down":
                    movePlayer(matrix, playerRow + 1, playerCol);
                    break;
                case "left":
                    movePlayer(matrix, playerRow, playerCol - 1);
                    break;
                case "right":
                    movePlayer(matrix, playerRow, playerCol + 1);
                    break;
            }

        }
        printMatrix(matrix);
    }

    private static void movePlayer(char[][] matrix, int nextRow, int nextCol) {

        if (isOutOfBounds (matrix, nextRow, nextCol)) {
            if (nextRow < 0) {
                nextRow = matrix.length - 1;
            } else if (nextRow >= matrix.length) {
                nextRow = 0;
            } else if (nextCol < 0) {
               nextRow = matrix[nextRow].length;
            } else if (nextCol >= matrix[nextRow].length) {
                nextRow = 0;
            }
        }
        if (matrix [nextRow][nextCol] == 'T') {
            return;
        } else if (matrix [nextRow][nextCol] == 'B') {
            playerRow = nextRow;
            playerCol = nextCol;
           movePlayer(matrix, nextRow, nextCol);
        } else if (matrix[nextRow][nextCol] == 'F') {
            hasWon = true;
        }
        matrix [playerRow][playerCol] = '-';
        matrix [nextRow][nextCol] = 'f';
        playerRow = nextRow;
        playerCol = nextCol;

    }

    private static boolean isOutOfBounds(char[][] matrix, int r, int c) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }
    public static void printMatrix (char [][] matrix) {
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
