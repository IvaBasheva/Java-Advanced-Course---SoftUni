package MultidimensionalArraysLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        int r = Integer.parseInt(scanner.nextLine());

        int [][] matrix = new int[r][];

        for (int i = 0; i < matrix.length; i++) {
            int [] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix [i] = arr;
        }

        int [] index = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int numberRow = index[0];
        int numberCol = index[1];

        int wrongValue = matrix [numberRow][numberCol];

        List<int []> correctValues = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix [row].length; col++) {
                if (matrix[row][col] == wrongValue) {
                    int correctValue = getNearbySum(matrix, row, col, wrongValue);
                    correctValues.add(new int []{row, col, correctValue});
                }
            }
        }
        for (int [] correctValue: correctValues) {
            matrix [correctValue [0]][correctValue[1]] = correctValue [2];
        }

        for (int []  arr : matrix) {
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    private static int getNearbySum(int[][] matrix, int row, int col, int wrongValue) {
        int sum = 0;

        if (isInBounce  (matrix, row + 1, col) && matrix [row + 1][col] != wrongValue) {
            sum += matrix[row + 1][col];
        }
        if (isInBounce  (matrix, row - 1, col) && matrix [row - 1][col] != wrongValue) {
            sum += matrix[row - 1][col];
        }
        if (isInBounce  (matrix, row, col + 1) && matrix [row][col + 1] != wrongValue) {
            sum += matrix[row][col + 1];
        }
        if (isInBounce  (matrix, row, col - 1) && matrix [row][col - 1] != wrongValue) {
            sum += matrix[row][col - 1];
        }
        return sum;
    }

    private static boolean isInBounce(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
