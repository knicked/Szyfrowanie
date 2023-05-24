public interface WordLoader {

    /**
     * Loads words in the order they appear in the file
     *
     * @param filename
     * @return Array of words
     */
    String[] loadWords(String filename);

    /**
     * Loads words in random order
     *
     * @param filename
     * @return Array of words
     */
    String[] loadWordsUnordered(String filename);
    /**
     * Loads words in alphabetic order
     *
     * @param filename
     * @return Array of words
     */
    String[] loadWordsAlphabetic(String filename);
}
