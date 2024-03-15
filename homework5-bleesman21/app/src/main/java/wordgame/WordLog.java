package wordgame;

import java.util.ArrayList;

public class WordLog {
    private ArrayList<Character> letters = new ArrayList<Character>();
    public boolean guessed (char letter)
    {
        letter = Character.toLowerCase(letter);
        for (char i: letters)
        {
            if (i == letter)
                return true;
        }
        letters.add(letter);
        return false;
    }
}
