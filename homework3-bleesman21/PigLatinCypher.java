import java.util.Scanner;

public class PigLatinCypher implements Cypher {
    private boolean isVowel (char chr) {
        if (chr == 'a' || chr == 'e' || chr == 'i' || chr == 'o' || chr == 'u' || chr == 'y') {
            return true;
        }
        return false;
    }
    public String encode (String str) {
        String temp = "";
        for (String i: str.split(" ")) {
            temp += encodeStr(i) + " ";
        }
        return temp.substring(0, temp.length()-1);
    }
    private String encodeStr (String str) {
        str = str.toLowerCase();
        if (isVowel(str.charAt(0)))
            return str + "way";
        else 
            return str.substring(1) + str.charAt(0) + "ay";
    }
    public String decode (String str) {
        String temp = "";
        for (String i: str.split(" ")) {
            temp += decodeStr(i) + " ";
        }
        return temp.substring(0, temp.length()-1);
    }
    private String decodeStr (String str) {
        str = str.toLowerCase();
        if (str.substring(str.length()-3, str.length()).equals("way"))
            return str.substring(0, str.length()-3);
        else
            return str.charAt(str.length()-3) + str.substring(0, str.length()-3);
    }
    public static void main (String[] args) {
        PigLatinCypher pigDriver = new PigLatinCypher();
        System.out.println("Enter text to be encrypted:");
        Scanner scanner = new Scanner(System.in);
        if (args[0].equals("e"))
            System.out.println("Encrypted text: "+pigDriver.encode(scanner.nextLine()));
        else if (args[0].equals("d"))
            System.out.println("Encrypted text: "+pigDriver.decode(scanner.nextLine()));
        scanner.close();
    }
}
