package averagevowels.demo;

import static org.junit.jupiter.api.Assertions.*;

import model.Sentence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class SentenceTest {

    private Sentence sentence;

    @BeforeEach
    public void setUp() {
        this.sentence = new Sentence();
    }

    @Test
    public void emptyListMapperTest() {
        sentence.sentenceMapper(Collections.emptyList());
        assertEquals(new HashMap<>(), sentence.getOutputMap());
    }

    @Test
    public void okListMapperTest() {
        sentence.sentenceMapper(Arrays.asList("line 1", "line 2", "line_3"));
        assertNotNull(sentence.getOutputMap());
    }

    @Test
    public void nullTest() {
        assertThrows(NullPointerException.class, () -> {
            sentence.sentenceMapper(null);
        });
    }
}