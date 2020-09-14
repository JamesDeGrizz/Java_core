package java.java_professional.lesson_6;

import java_professional.lesson_6.*;
import org.junit.Assert;
import org.junit.Test;

public class TestClassP1 {
    private ClassP1 testClass;

//    @BeforeEach
//    public void init() {
//        testClass = new ClassP1();
//    }

    @Test
    public void testRegularWork() {
        ClassP1 testClass = new ClassP1();
        Assert.assertEquals(3, testClass.cutAfterLastFour(new int[]{1, 2, 3, 4, 6, 7, 8}).length);
    }
}
