package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int [][] matrix = new  int[n][n];

        for (int i = 0; i < n; i++) {
            int [] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix [i] = arr;
        }

        int primaryDiagonalSum = 0;

        for (int index = 0; index < matrix.length; index++) {
            primaryDiagonalSum += matrix [index][index];
        }

        int secondaryDiagonalSum = 0;

        for (int row = matrix.length - 1, col = 0; row >= 0 && col < matrix.length; row--, col ++) {
            secondaryDiagonalSum += matrix [row][col];
        }

        int difference = Math.abs(primaryDiagonalSum - secondaryDiagonalSum);
        System.out.println(difference);
    }
}
