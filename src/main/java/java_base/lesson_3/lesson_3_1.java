package java_base;

import java.util.Random;
import java.util.Scanner;

public class lesson_3_1 {
    private static Scanner sc = new Scanner(System.in);
    private static Random rand = new Random();
    private static String[] words = {"apple", "orange", "lemon", "banana",
                                     "apricot", "avocado", "broccoli", "carrot",
                                     "cherry", "garlic", "grape", "melon",
                                     "leak", "kiwi", "mango", "mushroom",
                                     "nut", "olive", "pea", "peanut",
                                     "pear", "pepper", "pineapple", "pumpkin",
                                     "potato"};

    public static void main(String[] args) {
        int index = rand.nextInt(words.length - 1);
        String word = words[index];
        StringBuilder builder = new StringBuilder("xxxxxxxxxxxxxxx");

        System.out.println("Hello! I choose a word for you. Try guess it!");
        System.out.println("Current word state: " + builder);

        while (true) {
            System.out.print("Your word: ");
            String userInput = sc.next();
            int minimumLength = Math.min(word.length(), userInput.length());

            for (int i = 0; i < minimumLength; ++i) {
                // this kostil' is possible because our hardcoded words array don't contains words with 'x'
                if (builder.charAt(i) == 'x') {
                    builder.setCharAt(i, word.charAt(i) == userInput.charAt(i) ? word.charAt(i) : 'x');
                }
            }

            if (word.contentEquals(builder.substring(0, word.length()))) {
                System.out.println("You win! My word is " + word);
                return;
            } else {
                System.out.println("Current word state: " + builder);
            }
        }
    }
}
