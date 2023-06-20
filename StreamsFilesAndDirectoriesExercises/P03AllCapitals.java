package StreamsFilesAndDirectoriesExercises;

import groovyjarjarasm.asm.util.Printer;

import java.io.*;
import java.util.Scanner;

public class P03AllCapitals {
    public static void main(String[] args) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter("resources2/outputNew.txt"));
        BufferedReader reader = new BufferedReader(new FileReader("resources2/input.txt"));

        reader.lines().forEach(line -> writer.println(line.toUpperCase()));
        reader.close();
        writer.close();
    }
}
