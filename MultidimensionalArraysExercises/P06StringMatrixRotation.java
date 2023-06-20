package MultidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String [] input = scanner.nextLine().split("[()]");
        int rotationNumber = Integer.parseInt(input[1]);
        int rotationAngle = rotationNumber % 360;

        String word = scanner.nextLine();

        List<String> list = new ArrayList<>();

        int maxLength = Integer.MIN_VALUE;

        while (!word.equals("END")) {
            list.add(word);
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
            word = scanner.nextLine();
        }

        int rows = list.size();
        int cols = maxLength;

        char [][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String currentWord = list.get(row);
            for (int col = 0; col < cols; col++) {
                if (col < currentWord.length()) {
                    char currentChar =currentWord.charAt(col);
                    matrix [row][col] = currentChar;
                } else {
                    matrix [row][col] = ' ';
                }
            }

        }

        if (rotationAngle == 0) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix [row][col]);
                }
                System.out.println();
            }
        } else if (rotationAngle == 90) {
            for (int col = 0; col < cols; col++) {
                for (int row = rows - 1; row >= 0 ; row--) {
                    System.out.print(matrix [row][col]);
                }
                System.out.println();
            }
        } else if (rotationAngle == 180) {
            for (int row = rows - 1; row >= 0; row--) {
                for (int col = cols - 1; col >= 0; col--) {
                    System.out.print(matrix [row][col]);
                }
                System.out.println();
                }
        } else if (rotationAngle == 270) {
            for (int col = cols - 1; col >= 0; col--) {
                for (int row = 0; row < rows; row++) {
                    System.out.print(matrix [row][col]);
                }
                System.out.println();
                }
            }
        }
    }



