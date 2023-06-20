package StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class P06WordCount {
    public static void main(String[] args) throws IOException {

        Scanner scanner =  new Scanner(new FileReader("resources2/words.txt"));
        String [] wordsToSearch = scanner.nextLine().split(" ");

        LinkedHashMap <String, Integer> map = new LinkedHashMap<>();

        for (String word : wordsToSearch) {
            map.put(word, 0);
        }

        Scanner fileScanner = new Scanner(new FileReader("resources2/text.txt"));

        String singleWord = fileScanner.next();

        while (fileScanner.hasNext()) {
            if (map.containsKey(singleWord)) {
                int occurrences = map.get(singleWord);
                occurrences ++;
                map.put(singleWord, occurrences);
            }
            singleWord = fileScanner.next();
        }
        PrintWriter writer = new PrintWriter (new FileWriter("resources2/results.txt"));
        map.entrySet().stream().forEach(entry -> writer.printf("%s - %d%n", entry.getKey(), entry.getValue()));



        fileScanner.close();
        scanner.close();
        writer.close();

    }
}
