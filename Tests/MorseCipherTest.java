import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MorseCipherTest {

    @Test
    void encrypt() {
        MorseCipher mors = new MorseCipher();
        String morse_school = "... -.-. .... --- --- .-..";
        assertEquals("school", mors.decrypt(morse_school));
        assertEquals(morse_school, mors.encrypt("school"));
    }
}