package cipher;

import org.junit.*;
import static org.junit.Assert.*;

import javax.swing.plaf.synth.SynthDesktopPaneUI;

public class ShiftCipherTest
{
    @Test
    public void myTest(){
       // add your test implementation below
       ShiftCipher cipher = new ShiftCipher(1);
       assertEquals("a".equals(cipher.encode("z")), true);
       assertEquals("z".equals(cipher.decode("a")), true);
    }
}
