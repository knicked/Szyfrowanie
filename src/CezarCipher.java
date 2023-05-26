import java.util.Arrays;

public class CezarCipher implements  Cipher{
    private int offset;
    public CezarCipher(int _offset)
    {
        this.offset = _offset % 26;
    }
    private String loopAndShift(String word, int shift)
    {
        try
        {
            char[] cipheredWord = new char[word.length()];
            for(int i = 0; i < word.length(); i++)
            {
                Character c = word.charAt(i);
                // A, B, ..., Z
                if(c >= 65 && c <= 90)
                    cipheredWord[i] = shiftChar(c, true, shift);
                // a, b, ..., z
                else if(c >= 97 && c <= 122)
                    cipheredWord[i] = shiftChar(c, false, shift);
                else
                    throw new Exception();
            }
            return new String(cipheredWord);
        }
        catch(Exception e)
        {
            System.out.println("Cezar::encrypt::loopAndShift:: prohibited characters on input");
            return null;
        }
    }

    public String encrypt(String word)
    {
        int shift = offset;
        return loopAndShift(word, shift);
    }
    private char shiftChar(Character c, boolean isBig, int shift)
    {
        int x;
        if(isBig)
        {
            x = c - 'A';
            x = (x + shift)%26;
            x = x + 'A';
        }
        else
        {
            x = c - 'a';
            x = (x + shift)%26;
            x = x + 'a';
        }
        char result = (char)x;
        return result;
    }

    @Override
    public String decrypt(String word) {
       int shift = 26 - offset;
       return loopAndShift(word, shift);
    }
}
