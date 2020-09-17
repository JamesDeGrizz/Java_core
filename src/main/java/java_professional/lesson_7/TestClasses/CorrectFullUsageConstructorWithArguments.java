package java_professional.lesson_7.TestClasses;

import java_professional.lesson_7.Annotations.AfterSuite;
import java_professional.lesson_7.Annotations.BeforeSuite;
import java_professional.lesson_7.Annotations.Test;

public class CorrectFullUsageConstructorWithArguments {
    public CorrectFullUsageConstructorWithArguments(String name, Integer age) {

    }

    @BeforeSuite
    public void BeforeTest() {
        System.out.println("CorrectFullUsageConstructorWithArguments BeforeTest");
    }

    @Test(priority = 1)
    public void WithAnnotationTest() {
        System.out.println("CorrectFullUsageConstructorWithArguments WithAnnotationTest");
    }

    @Test(priority = 5)
    public void WithAnnotationTest2() {
        System.out.println("CorrectFullUsageConstructorWithArguments WithAnnotationTest2");
    }

    @Test(priority = 10)
    public void WithAnnotationTest3() {
        System.out.println("CorrectFullUsageConstructorWithArguments WithAnnotationTest3");
    }

    public void WithoutAnnotationTest() {
        System.out.println("CorrectFullUsageConstructorWithArguments WithoutAnnotationTest");
    }

    @AfterSuite
    public void AfterTest() {
        System.out.println("CorrectFullUsageConstructorWithArguments AfterTest");
    }
}
