package cipher;

public class ShiftCipher{
   private int shiftValue;
   public ShiftCipher(int shiftValue){
      this.shiftValue = shiftValue;
   }

   public String encode(String text){
      String encoded = "";
      for (char c: text.toCharArray()){
         encoded = encoded + (char)(c + shiftValue);
      }
      return encoded;
   }

   public String decode(String text){
      String decoded = "";
      for (char c: text.toCharArray()){
         decoded = decoded + (char)(c - shiftValue);
      }
      return decoded;
   }
}
