package wordgame;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Dictionary
{
   private String fileName;
   ArrayList<String> words;

   public Dictionary(String fileName)
   {
      this.fileName = fileName;
      words = new ArrayList<String>();
      words.add("chocolate");
      //read the words from the file
      File file = new File(fileName);
      try {
         Scanner scanner = new Scanner(file);
         while (scanner.hasNextLine())
         {
            words.add(scanner.nextLine());
         }
      } catch (Exception e) {}
   }

   public ArrayList<String> getWords()
   {
      return words;
   }
}
