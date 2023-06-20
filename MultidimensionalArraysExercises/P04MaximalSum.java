package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String [] dimensions = scanner.nextLine().split("\\s+");

        int r = Integer.parseInt(dimensions[0]);
        int c = Integer.parseInt(dimensions[1]);

        int [][] matrix = new int[r][c];

        for (int i = 0; i < matrix.length; i++) {
            int [] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix [i] = arr;
        }

        int maxSum = Integer.MIN_VALUE;
        int bestStartingRow = 0;
        int bestStartingCol = 0;

        for (int row = 0; row < r - 2; row++) {
            for (int col = 0; col < c - 2; col++) {
                int sum = 0;

                for (int currentRow = row; currentRow < row + 3; currentRow++) {
                    for (int currentCol = col; currentCol < col + 3; currentCol++) {
                        sum +=  matrix [currentRow][currentCol];
                    }
                }
                if (sum > maxSum) {
                    maxSum = sum;
                    bestStartingRow = row;
                    bestStartingCol = col;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        for (int row = bestStartingRow; row < bestStartingRow + 3 ; row++) {
            for (int col = bestStartingCol; col < bestStartingCol + 3 ; col++) {
                System.out.print(matrix [row][col] + " ");
            }
            System.out.println();
        }

    }
}
