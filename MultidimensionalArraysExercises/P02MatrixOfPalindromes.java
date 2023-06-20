package MultidimensionalArraysExercises;

import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String [] input = scanner.nextLine().split("\\s+");

        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        String [][] matrix = new String[r][c];

        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                char firstAndLastSymbol = (char) ('a' + row);
                char middleSymbol = (char) ('a' + row + col);
                matrix [row][col] = "" + firstAndLastSymbol + middleSymbol + firstAndLastSymbol;
            }
        }

        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                System.out.print(matrix [row][col] + " ");
            }
            System.out.println();
        }
    }
}
