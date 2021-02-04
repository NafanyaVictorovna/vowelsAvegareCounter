package model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor
public class Sentence {

    @Getter
    private Map<String, Double> outputMap;

    private final Map<WordInfo, Integer> sentenceMap = new HashMap<>();

    public void sentenceMapper(List<String> lines) {
        for (String line: lines) {
            Arrays.stream(line.trim().split(" "))
                    .forEach(word -> sentenceMap.put(new WordInfo(word), word.length()));
        }

        outputMap = sentenceMap.entrySet().stream()
                .collect(Collectors.groupingBy(sentenceMapEntry -> sentenceMapEntry.getKey().toString(),
                        Collectors.averagingLong(sentenceMapEntry -> sentenceMapEntry.getKey().getVowelsCount())));
    }
}
