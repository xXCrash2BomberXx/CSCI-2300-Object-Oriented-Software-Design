package homework4.bleesman21;

public class SecretWord {
    private String visible = "_ _ _ _ _ _ _ _ _ ";
    private String hidden = "chocolate";
    SecretWord () {}
    SecretWord (String word) {
        this.hidden = word;
        visible = "";
        for (int i=0; i < hidden.length(); i++)
            visible += "_ ";
    }
    public boolean guess (String letter) {return guess(letter.charAt(0));}
    public boolean guess (char letter) {
        boolean flag = false;
        for (int i=0; i < hidden.length(); i++) {
            if (visible.charAt(i*2) == '_' && letter == hidden.charAt(i)) {
                visible = visible.substring(0, i*2) + letter + visible.substring(i*2+1);
                flag = true;
            }
        }
        return flag;
    }
    public boolean solved () {
        for (char c: visible.toCharArray())
            if (c == '_')
                return false;
        return true;
    }
    public String current () {return visible;}
    public String reveal () {return hidden;}
    public static void main (String[] args) {}
}
