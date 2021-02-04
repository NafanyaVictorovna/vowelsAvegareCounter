package model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
public class WordInfo {

    @Getter
    private Set<Character> vowels;
    @Getter
    private long vowelsCount;
    @Getter
    private String value;

    private final List<Character> commonVowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'y');

    public WordInfo(String value) {
        this.value = value.toLowerCase();
        putToVowels();
    }

    private void putToVowels() {
        vowels = this.value.chars().mapToObj(c -> (char) c)
                .filter(commonVowels::contains)
                .collect(Collectors.toSet());

        vowelsCount = this.value.chars().mapToObj(c -> (char) c)
                .filter(commonVowels::contains).count();
    }

    public String toString() {
       return "(" + this.getVowels().toString() + ", " + this.getValue().length() + ")";
    }
}
