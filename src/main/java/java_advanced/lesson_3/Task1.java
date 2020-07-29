package java_advanced.lesson_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Task1 {
    private String[] words;
    private HashMap<String, Integer> repeats = new HashMap<String, Integer>();
    private HashSet<String> uniqueWords = new HashSet<String>();

    public void initWords(String[] words) {
        this.words = words;
    }

    public void doWork() {
        for (String word : words) {
            uniqueWords.add(word);
            repeats.put(word, repeats.containsKey(word) ? repeats.get(word) + 1 : 1);
        }
    }

    public void printUniques() {
        for (String word : uniqueWords) {
            System.out.println("Next unique word is " + word);
        }
    }

    public void printRepeats() {
        for (Map.Entry<String, Integer> pair : repeats.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Word ");
            sb.append(pair.getKey());
            sb.append(" noticed ");
            sb.append(pair.getValue());
            sb.append(" times");

            System.out.println(sb.toString());
        }
    }
}
