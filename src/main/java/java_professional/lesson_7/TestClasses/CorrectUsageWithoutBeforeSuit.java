package java_professional.lesson_7.TestClasses;

import java_professional.lesson_7.Annotations.*;

public class CorrectUsageWithoutBeforeSuit {
    @Test(priority = 1)
    public void WithAnnotationTest() {
        System.out.println("CorrectUsageWithoutBeforeSuit WithAnnotationTest");
    }

    public void WithoutAnnotationTest() {
        System.out.println("CorrectUsageWithoutBeforeSuit WithoutAnnotationTest");
    }

    @AfterSuite
    public void AfterTest() {
        System.out.println("CorrectUsageWithoutBeforeSuit AfterTest");
    }
}
