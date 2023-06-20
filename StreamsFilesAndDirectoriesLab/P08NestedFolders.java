package StreamsFilesAndDirectoriesLab;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class P08NestedFolders {
    public static void main(String[] args) {

        String path = "C:\\Users\\Iva and Aks\\IdeaProjects\\Java Advanced\\resources\\Files-and-Streams";

        File root = new File(path);

        List<String> fileList = new ArrayList<>();

        fileList.add(root.getName());

        File[] files = root.listFiles();
        for (File f: files) {
            if (f.isDirectory()) {
                fileList.add(f.getName());
                File[] nested = f.listFiles();
                for (File n : nested) {
                   fileList.add(n.getName());
                }
            }
            else {
                fileList.add(f.getName());
            }
        }
        for (String name : fileList) {
            System.out.println(name);
        }
        System.out.printf("[%d] folders", fileList.size());
    }
}
