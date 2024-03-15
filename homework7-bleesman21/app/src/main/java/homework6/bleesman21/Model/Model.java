package homework6.bleesman21.Model;

import java.io.IOException;

import homework6.bleesman21.Control.Control;
import homework6.bleesman21.View.View;


public class Model {
    private WordGen wordGen;
    private View view;
    String word;
    char[] guessed;
    int found = 0;
    int left = 5;
    public Model (Control control) {
        try {
            wordGen = new WordGen("dictionary.txt");
        } catch (IOException e) {}
        word = wordGen.getWord();
        guessed = new char[word.length()*2];
        for (int i = 0; i < word.length(); i++) {
            guessed[i*2] = '_';
            guessed[i*2+1] = ' ';
        }
        view = new View(control);
        view.update(new String(guessed), left);
    }
    public void guess (char letter) {
        boolean found = false;
        for (int i = 0; i < word.length(); i++)
            if (letter == Character.toLowerCase(word.charAt(i))) {
                guessed[i*2] = word.charAt(i);
                found = true;
                this.found++;
            }
        if (this.found == word.length()) {
            view.reveal(true, word);
            return;
        }
        if (!found)
            left--;
        view.update(new String(guessed), left);
        if (left <= 0)
            view.reveal(false, word);
    }
}
