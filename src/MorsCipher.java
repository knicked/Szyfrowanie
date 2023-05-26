import java.util.HashMap;
import java.util.Map;

public class MorsCipher implements Cipher{
    private final String[] morsCode = {".-",   "-...", "-.-.", "-..",  ".",
            "..-.", "--.",  "....", "..",   ".---",
            "-.-",  ".-..", "--",   "-.",   "---",
            ".--.", "--.-", ".-.",  "...",  "-",
            "..-",  "...-", ".--",  "-..-", "-.--",
            "--..", "|" };
    private Map<String, Character> morsToLetters;
    public MorsCipher()
    {
        morsToLetters = new HashMap<>();
        for(int i = 0; i < 26; i++)
            morsToLetters.put(morsCode[i], (char)('a' + i));
    }
    public String encrypt(String word)
    {
        try
        {
            String[] cipheredWord = new String[word.length()];
            for(int i = 0; i < word.length(); i++)
            {
                char c = word.charAt(i);
                // A, B, ..., Z
                if(c >= 65 && c <= 90)
                    cipheredWord[i] = morsCode[c - 'A'];
                // a, b, ..., z
                else if(c >= 97 && c <= 122)
                    cipheredWord[i] = morsCode[c - 'a'];
                else
                    throw new Exception();
            }
            return String.join(" ", cipheredWord);
        }
        catch (Exception e)
        {
            System.out.println("Morse::encrypt::loopAndShift:: prohibited characters on input");
            return null;
        }

    }
    public String decrypt(String word)
    {
        // assumption is that encrypted letters in word are separated by spaces
        String[] splittedMorse = word.split(" ");
        char[] decipheredWord = new char[splittedMorse.length];

        for(int i = 0; i < splittedMorse.length; i++)
        {
            decipheredWord[i] = morsToLetters.get(splittedMorse[i]);
        }
        return new String(decipheredWord);
    }

}
