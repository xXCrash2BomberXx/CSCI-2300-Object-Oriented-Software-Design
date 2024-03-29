package wordgame;

import java.util.ArrayList;
import java.util.Random;

public class Game
{
   public static final int WRONG_LIMIT = 5;
   public static String pickWord(String fileName)
   {
      Dictionary dictionary = new Dictionary(fileName);
      ArrayList<String> allWords = dictionary.getWords();
      Random randomizer = new Random();
      int randomLocation = randomizer.nextInt(allWords.size());
      return allWords.get(randomLocation);
   }

   public static void main(String []args)
   {
      SecretWord secretWord = new SecretWord(pickWord("dictionary.txt"));
      WordLog wordLog = new WordLog();
      int wrongGuesses = 0;

      System.out.println("Welcome to the word guessing game");
      System.out.println("Guess the secret word: " + secretWord.getCurrentGuess());

      while (secretWord.hasUnopenedLetters() && wrongGuesses < WRONG_LIMIT)
      {
         UserInput.askForInput();
         char nextLetter = UserInput.getNextLetter();
         if (!wordLog.guessed(nextLetter))
         {
            boolean correct = secretWord.makeGuess(nextLetter);
            if (!correct)
            {
               wrongGuesses++;
               System.out.println("No such letter. You have " + 
                  (WRONG_LIMIT - wrongGuesses) + " incorrect attempts left");
            }
         }
         else
         {
            System.out.println("You've already guessed: "+nextLetter);
         }
         System.out.println("Your current guess is: " + secretWord.getCurrentGuess());
      }

      if (!secretWord.hasUnopenedLetters())
      {
         System.out.println("Congrats! You guessed the secret word.");
      }
      else
      {
         System.out.println("You lose! The secret word was: " + secretWord.reveal());
      }
   }

}
