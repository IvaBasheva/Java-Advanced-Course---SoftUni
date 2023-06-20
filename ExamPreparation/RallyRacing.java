package ExamPreparation;

import java.util.Scanner;

public class RallyRacing {
    public static int carRow = 0;
    public static int carCol = 0;
    public static boolean hasFinished = false;
    public static int kilometersPassed;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String racingNumber = scanner.nextLine();

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            String matrixRow = scanner.nextLine().replaceAll(" ", "");
            matrix[row] = matrixRow.toCharArray();
        }

        String command = scanner.nextLine();

        while (!command.equals("End") && !hasFinished) {
            switch (command) {
                case "up":
                    driveCar(matrix, carRow - 1, carCol);
                    break;
                case "down":
                    driveCar(matrix, carRow + 1, carCol);
                    break;
                case "left":
                    driveCar(matrix, carRow, carCol - 1);
                    break;
                case "right":
                    driveCar(matrix, carRow, carCol + 1);
                    break;
            }
            command = scanner.nextLine();
        }
        matrix [carRow][carCol] = 'C';

        if (hasFinished) {
            System.out.printf("Racing car %s finished the stage!%n", racingNumber);
        }  else {
            System.out.printf("Racing car %s DNF.%n", racingNumber);
        }
        System.out.printf("Distance covered %s km.%n",kilometersPassed);

        printMatrix(matrix);

    }
    private static void driveCar (char [][] matrix, int nextRow, int nextCol) {
        if (matrix [nextRow][nextCol] == '.' ) {
            carRow = nextRow;
            carCol = nextCol;
            kilometersPassed += 10;
        }
        if (matrix [nextRow][nextCol] == 'T') {
            carRow = nextRow;
            carCol = nextCol;
            matrix [nextRow][nextCol] = '.';

            goingTroughTheMatrix(matrix, nextRow, nextCol, 'T', '.');
            kilometersPassed += 30;
        }
        if (matrix [nextRow][nextCol] == 'F') {
            goingTroughTheMatrix(matrix, nextRow, nextCol, 'F', 'C');
            carRow = nextRow;
            carCol = nextCol;
            hasFinished = true;
            kilometersPassed += 10;
        }
    }


    private static void goingTroughTheMatrix (char[][] matrix, int nextRow, int nextCol,
                                              char toReach, char toReplace) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                if (matrix[rows][cols] == toReach) {
                    carRow = rows;
                    carCol = cols;
                    matrix[rows][cols] = toReplace;
                    break;
                }
            }
        }
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
