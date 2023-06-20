package ExamPreparation;

import java.util.Scanner;

public class StickyFingers {
    public static int thiefRow = 0;
    public static int thiefCol = 0;
    public static boolean getCaught = false;
    public static int stolenMoney = 0;

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String [] commandLine = scanner.nextLine().split(",");

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            String matrixRow = scanner.nextLine().replaceAll(" ", "");
            matrix[row] = matrixRow.toCharArray();
        }

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                if (matrix [rows][cols] == 'D') {
                    thiefRow = rows;
                    thiefCol = cols;
                    break;
                }
            }
        }

        for (int i = 0; i < commandLine.length; i++) {
            if (getCaught) {
                break;
            }
            String command = commandLine[i];

            switch (command) {
                case "up":
                    moveThroughTheField(matrix, thiefRow - 1, thiefCol);
                    break;
                case "down":
                    moveThroughTheField(matrix, thiefRow + 1, thiefCol);
                    break;
                case "left":
                    moveThroughTheField(matrix, thiefRow, thiefCol - 1);
                    break;
                case "right":
                    moveThroughTheField(matrix, thiefRow, thiefCol + 1);
                    break;
            }
        }
        if (getCaught) {
            System.out.printf("You got caught with %d$, and you are going to jail.%n", stolenMoney);
        } else {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", stolenMoney);
        }
        printMatrix(matrix);
    }

    private static void moveThroughTheField(char[][] matrix, int nextRow, int nextCol) {

        if (isOutOfBounds(matrix, nextRow, nextCol)) {
            System.out.println("You cannot leave the town, there is police outside!");
            return;
        }
        if (matrix[nextRow][nextCol] == '+') {
            matrix [thiefRow][thiefCol] = '+';
            matrix[nextRow][nextCol] = 'D';
            thiefRow = nextRow;
            thiefCol =  nextCol;
        } else if (matrix[nextRow][nextCol] == '$') {
            matrix [thiefRow][thiefCol] = '+';
            matrix[nextRow][nextCol] = 'D';
            thiefRow = nextRow;
            thiefCol =  nextCol;
            stolenMoney += thiefRow * thiefCol;
            System.out.printf("You successfully stole %d$.%n", thiefRow * thiefCol);
        } else if (matrix[nextRow][nextCol] == 'P') {
            matrix [thiefRow][thiefCol] = '+';
            thiefRow = nextRow;
            thiefCol =  nextCol;
            matrix [thiefRow][thiefCol] = '#';
            getCaught = true;

        }


    }
    private static boolean isOutOfBounds(char[][] matrix, int r, int c) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }
    public static void printMatrix (char [][] matrix) {
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
