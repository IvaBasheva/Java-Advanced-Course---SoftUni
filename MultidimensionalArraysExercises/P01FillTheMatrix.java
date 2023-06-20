package MultidimensionalArraysExercises;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String [] input = scanner.nextLine().split(", ");

        int n = Integer.parseInt(input[0]);
        String pattern = input[1];

        int [][] matrix = new int[n][n];

        if (pattern.equals("A")) {
            patternA(matrix, n); {
                printMatrix (matrix);
            }
        } else {
            patternB(matrix, n); {
                printMatrix (matrix);
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix [r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static void patternB(int[][] matrix, int n) {
        int i = 1;

        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix [row][col] = i;
                    i++;
                }
            } else {
                for (int row = n - 1 ; row >= 0 ;row--) {
                    matrix [row][col] = i;
                    i++;
                }
            }
        }
    }

    private static void patternA(int [][] matrix, int n) {
        int i = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix [row][col] = i;
                i++;
            }
        }
    }
}
