package StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.util.Scanner;

public class P04ExtractIntegers {
    public static void main(String[] args) throws IOException {

        String path = "resources/input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        Scanner scanner =  new Scanner(inputStream);
        FileOutputStream outputStream = new FileOutputStream("extractIntegers.txt");
        PrintWriter out = new PrintWriter(outputStream);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
               out.println(scanner.nextInt());
            }
            scanner.next();
        }
        out.close();
    }
}
