package commandlineparser;

import cipher.Cipher;

public record Parameters(
        Action action,
        Cipher cipher,
        String inputFileName,
        String outputFileName) {}
