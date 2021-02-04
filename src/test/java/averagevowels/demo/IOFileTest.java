package averagevowels.demo;

import fileIO.IOFile;
import model.Sentence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class IOFileTest {

    private final String outputFileName = "./src/main/resources/results/output.txt";
    private IOFile ioFile;

    @BeforeEach
    public void setUp() {
        ioFile = new IOFile();
    }

    @Test
    public void correctReadArgs() {
        String results = "Platon made bamboo boats";
        String inputFileName = "./src/main/resources/results/input.txt";
        assertEquals(results, ioFile.readInputFile(inputFileName).get(0));
    }

    @Test
    public void correctWriteOutputArgs() {
        Sentence testSentence = new Sentence();
        testSentence.sentenceMapper(Collections.singletonList("Platon made bamboo boats"));
        Map<String, Double> testMap = testSentence.getOutputMap();

        assertDoesNotThrow(() -> ioFile.writeOutputFile(testMap, outputFileName));
    }

    @Test
    public void writeFileWithNullMap() {
        assertThrows(NullPointerException.class, () -> ioFile.writeOutputFile(null, outputFileName));
    }

    @Test
    public void writeFileWithEmptyMap() {
        Map<String, Double> testMap = new HashMap<>();

        assertDoesNotThrow(() -> ioFile.writeOutputFile(testMap, outputFileName));
    }

    @Test
    public void emptyInputFileNameTest() {
        assertDoesNotThrow(() -> ioFile.readInputFile(""));
    }

    @Test
    public void emptyOutputFileNameTest() {
        assertDoesNotThrow(() -> ioFile.writeOutputFile(new HashMap<>(), ""));
    }

    @Test
    public void nullInputFileNameTest() {
        assertThrows(NullPointerException.class, () -> ioFile.readInputFile(null));
    }

    @Test
    public void nullOutputFileNameTest() {
        assertThrows(NullPointerException.class, () -> ioFile.writeOutputFile(new HashMap<>(),null));
    }
}