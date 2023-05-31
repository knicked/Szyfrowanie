import cipher.CezarCipher;

import static org.junit.jupiter.api.Assertions.*;

class CezarCipherTest {

    @org.junit.jupiter.api.Test
    void encryptDecrypt() {
        CezarCipher cezar = new CezarCipher(3);
        String str1 = "ABYFI";
        assertEquals("DEBIL",cezar.encrypt(str1));
        assertEquals(str1, cezar.decrypt("DEBIL"));

        String ZAY = "ZAX";
        assertEquals("CDA", cezar.encrypt(ZAY));
        assertEquals(ZAY, cezar.decrypt("CDA"));

        String ala = "alaXYZxyz";
        assertEquals("dodABCabc", cezar.encrypt(ala));
        assertEquals(ala, cezar.decrypt("dodABCabc"));
    }
}