import commandlineparser.*;
import wordaccess.FileWordLoader;
import wordaccess.FileWordSaver;
import wordaccess.WordLoader;

public class Main {
    public static void main(String[] args) {
        try {
            Parameters parameters = new CommandLineParser().getParameters(args);

            String[] processedWords = processWords(getWords(parameters), parameters);

            new FileWordSaver().saveWordsToFile(processedWords,
                    parameters.outputFileName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    private static String[] getWords(Parameters parameters) {
        WordLoader fileWordLoader = new FileWordLoader();

        return switch (parameters.wordOrder()) {
            case SameAsInputFile -> fileWordLoader.loadWordsFromFile(parameters.inputFileName());
            case Unordered -> fileWordLoader.loadWordsFromFileUnordered(parameters.inputFileName());
            case Alphabetic -> fileWordLoader.loadWordsFromFileAlphabetic(parameters.outputFileName());
        };
    }

    private static String[] processWords(String[] words, Parameters parameters) {
        String[] processedWords = words.clone();

        for (int i = 0; i < words.length; i++) {
            switch (parameters.action()) {
                case Encrypt ->
                    processedWords[i] = parameters.cipher().encrypt(words[i]);
                case Decrypt ->
                    processedWords[i] = parameters.cipher().decrypt(words[i]);
            }
        }

        return processedWords;
    }
}