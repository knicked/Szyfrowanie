package wordaccess;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileWordLoader implements WordLoader {
    private String[] loadWords(String filename, Collection<String> structure) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNext()) {
                structure.add(scanner.next());
            }
            return structure.toArray(new String[] {});
        }
        catch (FileNotFoundException e) {
            System.out.println("Error while loading words from file: " + e.getMessage());
            return new String[] {};
        }
    }

    public String[] loadWordsFromFile(String filename) {
        return loadWords(filename, new ArrayList<>());
    }

    public String[] loadWordsFromFileUnordered(String filename) {
        return loadWords(filename, new HashSet<>());
    }

    public String[] loadWordsFromFileAlphabetic(String filename) {
        return loadWords(filename, new TreeSet<>());
    }
}
