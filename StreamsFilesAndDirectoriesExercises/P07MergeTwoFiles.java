package StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class P07MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        Path firstFile = Paths.get("resources2/inputOne.txt");
        Path secondFile = Paths.get("resources2/inputTwo.txt");

        List <String> firstFileLines = Files.readAllLines(firstFile);
        List <String> secondFileLines = Files.readAllLines(secondFile);

        Path output = Paths.get("resources2/output.txt");
        Files.write(output, firstFileLines, StandardOpenOption.APPEND);
        Files.write(output, secondFileLines, StandardOpenOption.APPEND);

    }
}
