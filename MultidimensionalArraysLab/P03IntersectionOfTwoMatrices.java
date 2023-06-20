package MultidimensionalArraysLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int r = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());



        char[][] firstMatrix = new char[r][c];

        for (int i = 0; i < r; i++) {

            char[] charArr = scanner.nextLine().toCharArray();
            firstMatrix[i] = charArr;
        }

        char[][] secondMatrix = new char[r][c];

        for (int i = 0; i < r; i++) {
            char[] charArr = scanner.nextLine().toCharArray();
            secondMatrix[i] = charArr;
        }

        for (int rows = 0; rows < firstMatrix.length; rows++) {
            for (int cols = 0; cols < firstMatrix[rows].length; cols++) {
                if (firstMatrix[rows][cols] != secondMatrix[rows][cols]) {
                    firstMatrix[rows][cols] = '*';
                }
            }
        }

        for (int rows = 0; rows < firstMatrix.length; rows++) {
            for (int cols = 0; cols < firstMatrix[rows].length; cols++) {
                System.out.print(firstMatrix[rows][cols]);
            }
            System.out.println();
        }
    }
}
