public interface WordLoader {
    /**
     * Loads words in the order they appear in the file
     *
     * @param filename
     * @return Array of words
     */
    String[] loadWordsFromFile(String filename);

    /**
     * Loads words in random order
     *
     * @param filename
     * @return Array of words
     */
    String[] loadWordsFromFileUnordered(String filename);
    /**
     * Loads words in alphabetic order
     *
     * @param filename
     * @return Array of words
     */
    String[] loadWordsFromFileAlphabetic(String filename);
}
