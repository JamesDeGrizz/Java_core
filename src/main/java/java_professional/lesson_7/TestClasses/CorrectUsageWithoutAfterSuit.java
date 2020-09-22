package java_professional.lesson_7.TestClasses;

import java_professional.lesson_7.Annotations.*;

public class CorrectUsageWithoutAfterSuit {
    @BeforeSuite
    public void BeforeTest() {
        System.out.println("CorrectUsageWithoutAfterSuit BeforeTest");
    }

    @Test(priority = 1)
    public void WithAnnotationTest() {
        System.out.println("CorrectUsageWithoutAfterSuit WithAnnotationTest");
    }

    public void WithoutAnnotationTest() {
        System.out.println("CorrectUsageWithoutAfterSuit WithoutAnnotationTest");
    }
}
