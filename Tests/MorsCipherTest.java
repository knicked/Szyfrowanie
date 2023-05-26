import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MorsCipherTest {

    @Test
    void encrypt() {
        MorsCipher mors = new MorsCipher();
        String morse_school = "... -.-. .... --- --- .-..";
        assertEquals("school", mors.decrypt(morse_school));
        assertEquals(morse_school, mors.encrypt("school"));
    }
}