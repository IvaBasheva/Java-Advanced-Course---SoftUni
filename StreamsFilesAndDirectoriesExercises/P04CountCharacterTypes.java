package StreamsFilesAndDirectoriesExercises;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class P04CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        int vowels = 0;
        int otherSymbols = 0;
        int punctuation = 0;

        FileReader reader = new FileReader("resources2/input.txt");
        int oneByte = reader.read();

        while (oneByte >= 0) {
            char symbol = (char) oneByte;

            if (isVowel(symbol)) {
                vowels ++;
            } else if (isPunctuation(symbol)) {
                punctuation ++;
            } else if (!Character.isWhitespace(symbol)){
                otherSymbols ++;
            }
            oneByte = reader.read();
        }
        reader.close();
        System.out.printf("Vowels: %d%n", vowels);
        System.out.printf("Other symbols: %d%n", otherSymbols);
        System.out.printf("Punctuation: %d", punctuation);

    }

    private static boolean isPunctuation(char symbol) {
        return (symbol == '!' || symbol == '.' || symbol == ',' || symbol == '?');
    }

    private static boolean isVowel(char symbol) {
        return  (symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u');
    }
}
