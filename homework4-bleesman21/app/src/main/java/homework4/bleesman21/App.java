package homework4.bleesman21;

import java.util.Scanner;

public class App {
    private SecretWord secretWord;
    private int incorrect = 0;
    App () {
        secretWord = new SecretWord();
        Scanner sc = new Scanner(System.in);
        while (!secretWord.solved() && incorrect < 5) {
            System.out.println(secretWord.current());
            System.out.print("Guess a character: ");
            if (!secretWord.guess((char) sc.next().charAt(0)))
                incorrect++;
        }
        if (incorrect < 5)
            System.out.println("You guessed '" + secretWord.reveal() + "' with "+incorrect+" incorrect guesses");
        else
            System.out.println("The word was '" + secretWord.reveal() + "'");
    }
    public static void main(String[] args) {
        new App();
    }
}
