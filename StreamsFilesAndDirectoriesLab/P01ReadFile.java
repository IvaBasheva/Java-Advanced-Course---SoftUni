package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class P01ReadFile {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String path = "C:\\Users\\Iva and Aks\\Desktop\\Java Advanced\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);

            int bytes = fileInputStream.read();

            while (bytes != -1) {

                    System.out.print(Integer.toBinaryString(bytes) + " ");
                bytes = fileInputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
