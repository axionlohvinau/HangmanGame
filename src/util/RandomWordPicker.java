package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class RandomWordPicker {
    private String filePath;
    private List<String> words;
    private Random random;

    public RandomWordPicker(String filePath) throws IOException {
        words = Files.readAllLines(Paths.get(filePath));
        this.filePath = filePath;
        random = new Random();
    }

    public String getRandomWord() {
        if (words.isEmpty()) return StringVariables.ERROR_FILE_EMPTY;
        return words.get(random.nextInt(words.size()));
    }
}
