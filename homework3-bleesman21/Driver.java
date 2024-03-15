import java.util.Scanner;

public interface Driver {
    public static void main (String[] args) {
        SecretInterpreter secretInterpreter;
        switch (args[1]) {
            case "pig":
                secretInterpreter = new SecretInterpreter(new PigLatinCypher());
                break;
            default:
                secretInterpreter = new SecretInterpreter(new CaesarCypher(Integer.parseInt(args[1].split(":")[1])));
                break;
        }
        Scanner scanner = new Scanner(System.in);
        if (args[0].equals("e")) {
            System.out.println("Enter text to be encrypted:");
            System.out.println("Encrypted text: "+secretInterpreter.hide(scanner.nextLine()));
        } else if (args[0].equals("d")) {
            System.out.println("Enter text to be decrypted:");
            System.out.println("Encrypted text: "+secretInterpreter.reveal(scanner.nextLine()));
        }
        scanner.close();
    }
}
