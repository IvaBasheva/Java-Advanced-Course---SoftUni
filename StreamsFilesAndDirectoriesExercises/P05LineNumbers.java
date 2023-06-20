package StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class P05LineNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("resources2/inputLineNumbers.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("resources2/output.txt"));

        String line = reader.readLine();

        int counter = 1;
        while (line != null) {
            writer.println(counter + ". " + line);
            counter ++;

            line = reader.readLine();
        }
        reader.close();
        writer.close();

    }
}
