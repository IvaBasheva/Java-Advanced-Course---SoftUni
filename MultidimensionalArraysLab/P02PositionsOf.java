package MultidimensionalArraysLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        int [] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int [][] matrix = new int[rows][cols];
        List<int[]> positions = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            int [] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix [i] = arr;

        }
        int numberToSearch = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == numberToSearch) {
                    positions.add(new int []{r,c});
                    isFound = true;
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        } else {
            for (int [] position : positions) {
                int row = position[0];
                int col = position[1];
                System.out.println(row + " " + col);

            }
        }
    }
}
