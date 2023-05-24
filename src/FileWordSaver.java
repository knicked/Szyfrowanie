import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWordSaver implements WordSaver {
    public void saveWordsToFile(String[] words, String filename) {
        try (Writer writer = new FileWriter(filename)){
            for (String word : words) {
                writer.write(word);
                writer.write('\n');
            }
        }
        catch (IOException e) {
            System.out.println("Error while saving words to file: " + e.getMessage());
        }
    }
}
