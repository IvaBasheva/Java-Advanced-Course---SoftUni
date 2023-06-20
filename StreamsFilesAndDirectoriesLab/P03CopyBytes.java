package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class P03CopyBytes {
    public static void main(String[] args) throws IOException {
        Scanner scanner =  new Scanner(System.in);

        String path = "resources/input.txt";

        FileInputStream fileInputStream = new FileInputStream(path);
        FileOutputStream fileOutputStream = new FileOutputStream("copyBytes.txt");


        int bytes = fileInputStream.read();

        while (bytes != -1) {
            if (bytes == ' ') {
               fileOutputStream.write((char)bytes);
            } else if (bytes == 10) {
                fileOutputStream.write((char)bytes);
            } else {
                String digits = String.valueOf(bytes);
                for (int i = 0; i < digits.length(); i++) {
                    fileOutputStream.write(digits.charAt(i));
                }
            }
            bytes = fileInputStream.read();
        }

    }
}
