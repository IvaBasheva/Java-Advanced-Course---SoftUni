package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        int [] dimensions = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];
        int sum = 0;

        int [][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            int [] arr = Arrays.stream(scanner.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix [i] = arr;
        }
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                sum += matrix [r][c];
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);

    }
}
