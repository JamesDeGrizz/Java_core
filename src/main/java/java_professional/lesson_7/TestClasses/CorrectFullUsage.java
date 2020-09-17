package java_professional.lesson_7.TestClasses;

import java_professional.lesson_7.Annotations.*;

public class CorrectFullUsage {
    @BeforeSuite
    public void BeforeTest() {
        System.out.println("CorrectFullUsage BeforeTest");
    }

    @Test(priority = 1)
    public void WithAnnotationTest() {
        System.out.println("CorrectFullUsage WithAnnotationTest");
    }

    @Test(priority = 5)
    public void WithAnnotationTest2() {
        System.out.println("CorrectFullUsage WithAnnotationTest2");
    }

    @Test(priority = 10)
    public void WithAnnotationTest3() {
        System.out.println("CorrectFullUsage WithAnnotationTest3");
    }

    public void WithoutAnnotationTest() {
        System.out.println("CorrectFullUsage WithoutAnnotationTest");
    }

    @AfterSuite
    public void AfterTest() {
        System.out.println("CorrectFullUsage AfterTest");
    }
}
