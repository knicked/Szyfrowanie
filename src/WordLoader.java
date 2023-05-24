public interface WordLoader {
    String[] loadWords(String filename);
    String[] loadWordsUnordered(String filename);
    String[] loadWordsAlphabetic(String filename);
}
