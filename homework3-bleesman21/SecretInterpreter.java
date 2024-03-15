public class SecretInterpreter {
    private Cypher cypher;
    SecretInterpreter (Cypher cypher) {
        this.cypher = cypher;
    }
    public String hide (String str) {
        return cypher.encode(str);
    }
    public String reveal (String str) {
        return cypher.decode(str);
    }
}
