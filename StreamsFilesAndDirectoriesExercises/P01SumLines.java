package StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class P01SumLines {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("resources2/input.txt"));

        String line = reader.readLine();

        while (line != null) {
            long sum = 0;

            char [] charactersFromLine = line.toCharArray();
            for (char character : charactersFromLine) {
                sum += character;

            }
            System.out.println(sum);
            line = reader.readLine();
        }
        reader.close();
    }
}
