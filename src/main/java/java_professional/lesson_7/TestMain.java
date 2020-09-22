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
        CorrectFullUsageConstructorWithArguments cfucwa = new CorrectFullUsageConstructorWithArguments("name", 13);

        System.out.println("Class without annotations");
        MyTest.start(wa.getClass());

        System.out.println("\n\nClass without AfterSuit");
        MyTest.start(cuwas.getClass());

        System.out.println("\n\nClass without BeforeSuit");
        MyTest.start(cuwbs.getClass());

        System.out.println("\n\nClass with 2 AfterSuit");
        try {
            MyTest.start(iuw2as.getClass());
        } catch (RuntimeException e) {
            System.out.println("Get exception with message " + e.getMessage());
        }

        System.out.println("\n\nClass with 2 BeforeSuit");
        try {
            MyTest.start(iuw2bs.getClass());
        } catch (RuntimeException e) {
            System.out.println("Get exception with message " + e.getMessage());
        }

        System.out.println("\n\nClass with full correct annotations usage");
        MyTest.start(cfu.getClass());

        System.out.println("\n\nClass with full correct annotations usage and complex constructor");
        try {
            MyTest.start(cfucwa.getClass());
        } catch (Exception e) {
            System.out.println("Get exception with message " + e.getMessage());
        }
    }
}
