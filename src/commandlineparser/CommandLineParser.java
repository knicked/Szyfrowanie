package commandlineparser;

import cipher.CezarCipher;
import cipher.Cipher;
import cipher.MorsCipher;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

public class CommandLineParser {
    public Parameters getParameters(String[] args) throws Exception {
        Options options = getAllPossibleOptions();

        CommandLine cmd = new DefaultParser().parse(options, args);

        if (cmd.getArgs().length != 2)
            throw new Exception("Please provide input and output file names.");

        return new Parameters(
                getAction(cmd),
                getCipher(cmd),
                getWordOrder(cmd),
                args[args.length - 2],
                args[args.length - 1]
        );
    }

    private Options getAllPossibleOptions() {
        Options options = new Options();

        options.addOption("e", false, "encode");
        options.addOption("d", false, "decode");
        options.addOption("m", false, "use Morse code");
        options.addOption("c", true, "use Caesar code");
        options.addOption("u", false, "get unordered words");
        options.addOption("a", false, "get words in alphabetical order");

        return options;
    }

    private Action getAction(CommandLine cmd) throws Exception {
        if (cmd.hasOption("e")) return Action.Encrypt;
        else if (cmd.hasOption("d")) return Action.Decrypt;
        else throw new Exception("Please specify action to perform with -e (encode) or -d (decode).");
    }

    private Cipher getCipher(CommandLine cmd) throws Exception {
        try {
            if (cmd.hasOption("c")) {
                return new CezarCipher(Integer.parseInt(cmd.getOptionValue("c")));
            }
            else if (cmd.hasOption("m")) {
                return new MorsCipher();
            }
            else {
                throw new Exception(
                        "Please specify a cipher with -c <offset> (Caesar) or -m (Morse).");
            }
        } catch (NumberFormatException e) {
            throw new Exception(cmd.getOptionValue("m") +
                    " is not a valid offset for the Caesar cipher.");
        }
    }

    private WordOrder getWordOrder(CommandLine cmd) {
        if (cmd.hasOption("u")) return WordOrder.Unordered;
        else if (cmd.hasOption("a")) return WordOrder.Alphabetic;
        else return WordOrder.SameAsInputFile;
    }
}
