package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        int n =  Integer.parseInt(scanner.nextLine());

        int [][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            int [] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix [i] = arr;
        }

        int row = 0;
        int col = 0;


        while (row < matrix.length && col < matrix [row].length) {
            System.out.print(matrix [row][col] + " ");
            row ++;
            col ++;
        }
        System.out.println();

        row = matrix.length - 1;
        col = 0;
        while (row >= 0 && col < matrix [row].length) {
            System.out.print(matrix [row][col] + " ");
            row --;
            col ++;
        }
    }
}
