package cipher;

public interface Cipher {
    /**
     * Encrypts a single word
     *
     * @param word Word to encrypt
     * @return Encrypted word
     */
    String encrypt(String word);
    /**
     * Decrypts a single word
     *
     * @param word Word to decrypt
     * @return Decrypted word
     */
    String decrypt(String word);
}
