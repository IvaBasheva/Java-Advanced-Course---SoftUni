package ExamPreparation;

import java.util.Scanner;

public class Armory {
    public static int officerRow;
    public static int officerCol;
    public static int searchedRow;
    public static int searchedCol;
    public static boolean isOutOfTheArmory = false;
    public  static int coins = 0;

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());



        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            String matrixRow = scanner.nextLine();
            matrix[row] = matrixRow.toCharArray();
        }
        goingTroughTheMatrix(matrix, 'A');
        officerRow = searchedRow;
        officerCol = searchedCol;

        while (scanner.hasNext() && coins < 65 && !isOutOfTheArmory) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    buyBlades(matrix, officerRow - 1, officerCol);
                    break;
                case "down":
                    buyBlades(matrix, officerRow + 1, officerCol);
                    break;
                case "left":
                    buyBlades(matrix, officerRow, officerCol - 1);
                    break;
                case "right":
                   buyBlades(matrix, officerRow, officerCol + 1);
                    break;
            }
        }

        if (isOutOfTheArmory) {
            System.out.println("I do not need more swords!");
        } else {
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.printf("The king paid %d gold coins.%n", coins);
        printMatrix(matrix);

    }
    private static void buyBlades (char [][] matrix, int nextRow, int nextCol) {
        if (isOutOfBounds(matrix, nextRow, nextCol)) {
            matrix [officerRow][officerCol] = '-';
            isOutOfTheArmory = true;
        } else if (matrix [nextRow][nextCol] == '-') {
            matrix [officerRow][officerCol] = '-';
            officerRow = nextRow;
            officerCol = nextCol;
        } else if (Character.isDigit(matrix[nextRow][nextCol])) {
            int bladePrice = Character.getNumericValue(matrix [nextRow][nextCol]);
            coins += bladePrice;
            matrix [officerRow][officerCol] = '-';
            officerRow = nextRow;
            officerCol = nextCol;
            matrix [officerRow][officerCol] = 'A';
        } else if (matrix [nextRow][nextCol] == 'M') {
            matrix [nextRow][nextCol] = '-';
            matrix [officerRow][officerCol] = '-';
            goingTroughTheMatrix(matrix, 'M');
            officerRow = searchedRow;
            officerCol = searchedCol;
            matrix [officerRow][officerCol] = 'A';
        }
    }
    private static void goingTroughTheMatrix (char[][] matrix, char searchedSymbol) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                if (matrix [rows][cols] == searchedSymbol){
                    searchedRow = rows;
                    searchedCol = cols;
                }
            }
        }
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
