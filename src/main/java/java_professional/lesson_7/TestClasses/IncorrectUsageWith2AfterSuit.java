package java_professional.lesson_7.TestClasses;

import java_professional.lesson_7.Annotations.*;

public class IncorrectUsageWith2AfterSuit {
    @BeforeSuite
    public void BeforeTest() {
        System.out.println("IncorrectUsageWith2AfterSuit BeforeTest");
    }

    public void WithAnnotationTest() {
        System.out.println("IncorrectUsageWith2AfterSuit WithAnnotationTest");
    }

    public void WithoutAnnotationTest() {
        System.out.println("IncorrectUsageWith2AfterSuit WithoutAnnotationTest");
    }

    @AfterSuite
    public void AfterTest() {
        System.out.println("IncorrectUsageWith2AfterSuit AfterTest");
    }

    @AfterSuite
    public void AfterTest2() {
        System.out.println("IncorrectUsageWith2AfterSuit AfterTest2");
    }
}
