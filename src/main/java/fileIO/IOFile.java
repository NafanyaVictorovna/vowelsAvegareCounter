package fileIO;

import lombok.NoArgsConstructor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@NoArgsConstructor
public class IOFile {

    public List<String> readInputFile(String fileName) {
        List<String> fileLines = new ArrayList<>();

        try (Stream<String> fileStream = Files.lines(Paths.get(fileName))) {
            fileLines = fileStream.collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println(e + e.getMessage());
        }

        return fileLines;
    }

    public void writeOutputFile(Map<String, Double> terminatedSentences, String outputFileName) {
        Path path = Paths.get(outputFileName);

        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for(Map.Entry<String, Double> entry: terminatedSentences.entrySet()) {
                bw.write(entry.getKey() + " -> " + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
