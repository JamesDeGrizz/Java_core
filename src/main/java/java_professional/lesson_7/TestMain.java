package java_professional.lesson_7;

import java_professional.lesson_7.TestClasses.*;

public class TestMain {
    public static void main(String[] args) {
        WithoutAnnotations wa = new WithoutAnnotations();

        CorrectUsageWithoutAfterSuit cuwas = new CorrectUsageWithoutAfterSuit();
        CorrectUsageWithoutBeforeSuit cuwbs = new CorrectUsageWithoutBeforeSuit();

        IncorrectUsageWith2AfterSuit iuw2as = new IncorrectUsageWith2AfterSuit();
        IncorrectUsageWith2BeforeSuit iuw2bs = new IncorrectUsageWith2BeforeSuit();

        CorrectFullUsage cfu = new CorrectFullUsage();

        System.out.println("Class without annotations");
        MyTest.start(wa.getClass(), wa);

        System.out.println("\n\nClass without AfterSuit");
        MyTest.start(cuwas.getClass(), cuwas);

        System.out.println("\n\nClass without BeforeSuit");
        MyTest.start(cuwbs.getClass(), cuwbs);

        System.out.println("\n\nClass with 2 AfterSuit");
        try {
            MyTest.start(iuw2as.getClass(), iuw2as);
        } catch (RuntimeException e) {
            System.out.println("Get exception with message " + e.getMessage());
        }

        System.out.println("\n\nClass with 2 BeforeSuit");
        try {
            MyTest.start(iuw2bs.getClass(), iuw2bs);
        } catch (RuntimeException e) {
            System.out.println("Get exception with message " + e.getMessage());
        }

        System.out.println("\n\nClass with full correct annotations usage");
        MyTest.start(cfu.getClass(), cfu);
    }
}
