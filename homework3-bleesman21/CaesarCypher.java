import java.util.Scanner;

public class CaesarCypher implements Cypher {
    private int shift = 0;
    CaesarCypher (int shift) {
        this.shift = shift;
    }
    public String encode (String str) {
        return shiftString(str, shift);
    }
    public String decode (String str) {
        return shiftString(str, -shift);
    }
    private String shiftString (String str, int shift) {
        str = str.toLowerCase();
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            char chr = str.charAt(i);
            if (chr >= 'a' && chr <= 'z')
                temp += (char) ((chr-'a'+shift+26)%26+'a');
            else
                temp += chr;
        }
        return temp;
    }
    public static void main (String[] args) {
        CaesarCypher caesarDriver = new CaesarCypher(Integer.parseInt(args[1]));
        System.out.println("Enter text to be encrypted:");
        Scanner scanner = new Scanner(System.in);
        if (args[0].equals("e"))
            System.out.println("Encrypted text: "+caesarDriver.encode(scanner.nextLine()));
        else if (args[0].equals("d"))
            System.out.println("Encrypted text: "+caesarDriver.decode(scanner.nextLine()));
        scanner.close();
    }
}
