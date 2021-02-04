package averagevowels.demo;

import static org.junit.jupiter.api.Assertions.*;

import model.WordInfo;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordInfoTest {

    private String testValue;
    private WordInfo testWordInfo;

    @Test
    public void withParameterTest() {
        testValue = "graziE";
        testWordInfo = new WordInfo(testValue);
        Set<Character> testSet = Stream.of('a', 'i', 'e').collect(Collectors.toSet());

        assertEquals(testValue.toLowerCase(), testWordInfo.getValue());
        assertEquals(testSet, testWordInfo.getVowels());
        assertEquals(3, testWordInfo.getVowelsCount());
        assertEquals("(" + testSet + ", " + testValue.length() + ")", testWordInfo.toString());
    }

    @Test
    public void nullParameterTest() {
        assertThrows(NullPointerException.class, () -> {
            new WordInfo(testValue);
        });
    }

    @Test
    public void emptyParameterTest() {
        testValue = "";
        testWordInfo = new WordInfo(testValue);
        assertEquals("", testWordInfo.getValue());
        assertEquals(new HashSet<>(), testWordInfo.getVowels());
        assertEquals(0, testWordInfo.getVowelsCount());
        assertEquals("([], 0)", testWordInfo.toString());
    }
}