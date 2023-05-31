package commandlineparser;

import cipher.Cipher;

public record Parameters(
        Action action,
        Cipher cipher,
        WordOrder wordOrder,
        String inputFileName,
        String outputFileName) {}
