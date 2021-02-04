package averagevowels.demo;

import fileIO.IOFile;
import model.Sentence;

public class DemoApplication {

    private static final String commonPathPart = "./src/main/resources/results/";
    private static final String[] simpleEx =
            {commonPathPart + "input.txt", commonPathPart + "output.txt"};
    private static final String[] emptyEx =
            {commonPathPart + "emptyFile.txt", commonPathPart + "emptyOutput.txt"};
    private static final String[] noVowelsEx =
            {commonPathPart + "noVowels.txt", commonPathPart + "noVowelsOutput.txt"};
    private static final String[] onlyVowelsEx =
            {commonPathPart + "wholeVowels.txt", commonPathPart + "wholeVowelsOutput.txt"};

    public static void main(String[] args) {
        runDifferentArgs(simpleEx[0], simpleEx[1]);
        runDifferentArgs(emptyEx[0], emptyEx[1]);
        runDifferentArgs(noVowelsEx[0], noVowelsEx[1]);
        runDifferentArgs(onlyVowelsEx[0], onlyVowelsEx[1]);
    }

    private static void runDifferentArgs(String input, String output) {
        IOFile ioFile = new IOFile();

        Sentence sentence = new Sentence();
        sentence.sentenceMapper(ioFile.readInputFile(input));

        ioFile.writeOutputFile(sentence.getOutputMap(), output);
    }

}
