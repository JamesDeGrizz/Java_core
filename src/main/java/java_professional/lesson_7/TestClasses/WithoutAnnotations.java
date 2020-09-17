package java_professional.lesson_7.TestClasses;

public class WithoutAnnotations {
    public void BeforeTest() {
        System.out.println("WithoutAnnotations BeforeTest");
    }

    public void WithAnnotationTest() {
        System.out.println("WithoutAnnotations WithAnnotationTest");
    }

    public void WithoutAnnotationTest() {
        System.out.println("WithoutAnnotations WithoutAnnotationTest");
    }

    public void AfterTest() {
        System.out.println("WithoutAnnotations AfterTest");
    }
}
