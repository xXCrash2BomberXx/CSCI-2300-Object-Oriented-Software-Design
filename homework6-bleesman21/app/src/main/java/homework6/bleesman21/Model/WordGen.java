package homework6.bleesman21.Model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordGen {
    private Random rand = new Random();
    private ArrayList<String> words;

    public WordGen(String fileName) throws IOException {
        words = new ArrayList<String>();
        Scanner scanner = new Scanner(new File(fileName));
        String nextWord = "";
        while (scanner.hasNextLine()) {
            nextWord = scanner.nextLine();
            words.add(nextWord);
        }
    }

    public String getWord() {
        return words.get(rand.nextInt(words.size()));
    }
}
