package StreamsFilesAndDirectoriesLab;

import java.io.File;
import java.util.Scanner;

public class P07ListFiles {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String path = "C:\\Users\\Iva and Aks\\IdeaProjects\\Java Advanced\\resources\\Files-and-Streams";

        File file = new File(path);

            File[] files = file.listFiles();
            for (File f: files) {
                if (!f.isDirectory()) {
                    System.out.printf("%s: [%d]%n", f.getName(), f.length());
                }
                }
    }
}
