package java_professional.lesson_7.TestClasses;

import java_professional.lesson_7.Annotations.*;

public class IncorrectUsageWith2BeforeSuit {
    @BeforeSuite
    public void BeforeTest() {
        System.out.println("IncorrectUsageWith2BeforeSuit BeforeTest");
    }

    @BeforeSuite
    public void BeforeTest2() {
        System.out.println("IncorrectUsageWith2BeforeSuit BeforeTest2");
    }

    @Test(priority = 1)
    public void WithAnnotationTest() {
        System.out.println("IncorrectUsageWith2BeforeSuit WithAnnotationTest");
    }

    public void WithoutAnnotationTest() {
        System.out.println("IncorrectUsageWith2BeforeSuit WithoutAnnotationTest");
    }

    @AfterSuite
    public void AfterTest() {
        System.out.println("IncorrectUsageWith2BeforeSuit AfterTest");
    }
}
