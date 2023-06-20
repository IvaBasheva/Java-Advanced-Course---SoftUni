package Exam;

import java.util.Scanner;

public class NavyBattle {
    public static int submarineRow;
    public static int submarineCol;
    public static int countMines;
    public static int destroyedBattlecruisers;
    public static boolean missionFailed = false;
    public static boolean missionAccomplished = false;

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            String matrixRow = scanner.nextLine();
            matrix[row] = matrixRow.toCharArray();
        }

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                if (matrix [rows][cols] == 'S'){
                    submarineRow = rows;
                    submarineCol = cols;
                }
            }
        }

        while (!missionFailed && !missionAccomplished) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    movingTroughTheBattlefield(matrix, submarineRow - 1, submarineCol);
                    break;
                case "down":
                    movingTroughTheBattlefield(matrix, submarineRow + 1, submarineCol);
                    break;
                case "left":
                    movingTroughTheBattlefield(matrix, submarineRow, submarineCol - 1);
                    break;
                case "right":
                    movingTroughTheBattlefield(matrix, submarineRow, submarineCol + 1);
                    break;
            }
        }
        if (missionAccomplished) {
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
        } else if (missionFailed) {
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n",
                    submarineRow, submarineCol);
        }
        printMatrix(matrix);
    }

    private static void movingTroughTheBattlefield(char[][] matrix, int nextRow, int nextCol) {
        if (matrix [nextRow][nextCol] == '-') {
            matrix [submarineRow][submarineCol] = '-';
            submarineRow = nextRow;
            submarineCol = nextCol;
            matrix [submarineRow][submarineCol] = 'S';
        } else if (matrix [nextRow][nextCol] == '*') {
            countMines ++;
            matrix [submarineRow][submarineCol] = '-';
            submarineRow = nextRow;
            submarineCol = nextCol;
            if (countMines == 3) {
                matrix [submarineRow][submarineCol] = 'S';
                missionFailed = true;
            } else {
                matrix [submarineRow][submarineCol] = '-';
            }
        } else if (matrix [nextRow][nextCol] == 'C') {
            destroyedBattlecruisers ++;
            matrix [submarineRow][submarineCol] = '-';
            submarineRow = nextRow;
            submarineCol = nextCol;
            if (destroyedBattlecruisers == 3) {
                matrix [submarineRow][submarineCol] = 'S';
                missionAccomplished = true;
            } else {
                matrix [submarineRow][submarineCol] = '-';
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
