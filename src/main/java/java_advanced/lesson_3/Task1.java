package java_advanced.lesson_3;

import java.util.HashMap;
import java.util.Map;

public class Task1 {
    private String[] words;
    private HashMap<String, Integer> repeats = new HashMap<String, Integer>();

    public void initWords(String[] words) {
        this.words = words;
    }

    public void doWork() {
        for (String word : words) {
            repeats.put(word, repeats.containsKey(word) ? repeats.get(word) + 1 : 1);
        }
    }

    public void printUniques() {
        for (String word : repeats.keySet()) {
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
