package wordgame;

import org.junit.*;
import static org.junit.Assert.*;

public class WordLogTest {
    @Test
    public void guessedUpperLower()
    {
        WordLog wordLog = new WordLog();
        assertEquals("guessed('A')", false, wordLog.guessed('A'));
        assertEquals("guessed('A')", true, wordLog.guessed('A'));
        assertEquals("guessed('a')", true, wordLog.guessed('a'));
    }
    @Test
    public void guessedAlternating()
    {
        WordLog wordLog = new WordLog();
        assertEquals("guessed('A')", false, wordLog.guessed('A'));
        assertEquals("guessed('B')", false, wordLog.guessed('B'));
        assertEquals("guessed('A')", true, wordLog.guessed('A'));
        assertEquals("guessed('B')", true, wordLog.guessed('B'));
        assertEquals("guessed('a')", true, wordLog.guessed('a'));
        assertEquals("guessed('b')", true, wordLog.guessed('b'));
    }
}
