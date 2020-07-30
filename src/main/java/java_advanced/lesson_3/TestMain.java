package java_advanced.lesson_3;

public class TestMain {
    public static void main(String[] args) {
        System.out.println("Task 3 part 1");

        Task1 t1 = new Task1();
        t1.initWords(new String[]{"cat", "dog", "fish", "cat", "giraffe", "cat", "elephant", "dog", "cat", "snake", "ferret", "dog", "cockroach", "fish"});
        t1.doWork();
        System.out.println("\nUniques: ");
        t1.printUniques();
        System.out.println("\nAll words: ");
        t1.printRepeats();

        System.out.println("\nTask 3 part 2");
        Phonebook pb = new Phonebook();
        pb.add("Smith", "89151111111");
        pb.add("Johnson", "89152222222");
        pb.add("Williams", "89153333333");
        pb.add("Jones", "89154444444");
        pb.add("Brown", "89155555555");
        pb.add("Davis", "89156666666");
        pb.add("Miller", "89157777777");
        pb.add("Wilson", "89158888888");

        pb.add("Smith", "89159999999");

        pb.add("Williams", "89150000000");

        try {
            pb.get("Johnson");
            pb.get("Smith");
            pb.get("Davis");
            pb.get("Williams");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Smth goes wrong:\n\t" + e.getMessage());
            System.exit(-1);
        }
    }
}
