package random;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadFile {
    public static void main(String[] args) {
        Map<String, Integer> wordCount = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader("C://test.txt"))) {
            List<String> searchWords = List.of("Java", "Spring", "File");
            reader.lines()
                    .map(l -> l.split(" "))
                    .forEach(w -> {
                        for (String word : w) {
                            if (searchWords.contains(word)) {
                                int value = wordCount.getOrDefault(word, 0);
                                wordCount.put(word, ++value);
                            }
                        }
                    });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        wordCount.entrySet().forEach(m -> System.out.println(m.getKey() + "->" + m.getValue()));
    }
}
