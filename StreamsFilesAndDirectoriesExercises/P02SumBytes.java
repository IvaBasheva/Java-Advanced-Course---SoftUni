package StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P02SumBytes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("resources2/input.txt"));

        String line = reader.readLine();

        long sum = 0;
        while (line != null) {

            char [] charactersFromLine = line.toCharArray();
            for (char character : charactersFromLine) {
                sum += character;

            }
            line = reader.readLine();
        }
        System.out.println(sum);
        reader.close();

    }
}
