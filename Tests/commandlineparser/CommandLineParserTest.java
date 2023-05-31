package commandlineparser;

import cipher.MorseCipher;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CommandLineParserTest {
    private static Stream<Arguments> provideTestsForGetParameters() {
        return Stream.of(
                Arguments.of(new String[]{}, null),
                Arguments.of(
                        new String[]{"-e", "-m", "infile", "outfile"},
                        new Parameters(
                                Action.Encrypt,
                                new MorseCipher(),
                                WordOrder.SameAsInputFile,
                                "infile",
                                "outfile")
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestsForGetParameters")
    void getParameters(String[] args, Parameters expectedParameters) {
        CommandLineParser commandLineParser = new CommandLineParser();

        try {
            Parameters parameters = commandLineParser.getParameters(args);
            assertEquals(parameters.action(), expectedParameters.action());
            assertEquals(parameters.cipher().getClass(), expectedParameters.cipher().getClass());
            assertEquals(parameters.wordOrder(), expectedParameters.wordOrder());
            assertEquals(parameters.inputFileName(), expectedParameters.inputFileName());
            assertEquals(parameters.outputFileName(), expectedParameters.outputFileName());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}