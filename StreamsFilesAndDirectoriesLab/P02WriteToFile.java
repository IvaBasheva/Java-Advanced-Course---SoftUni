package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class P02WriteToFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String path = "resources/input.txt";

            FileInputStream fileInputStream = new FileInputStream(path);
        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

        Set<Character> punctuationSet = Set.of(',', '.', '!', '?');

            int bytes = fileInputStream.read();

            while (bytes != -1) {
                char symbol = (char) bytes;

                boolean isPunctuation = punctuationSet.contains(symbol);

                if (!isPunctuation) {
                    fileOutputStream.write(symbol);
                }

                bytes = fileInputStream.read();
            }

    }
}
