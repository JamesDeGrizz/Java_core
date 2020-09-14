package java_professional.lesson_6;

import org.junit.*;

public class ClassP1Test {
    private ClassP1 testClass;

    @Before
    public void init() {
        testClass = new ClassP1();
    }

    @Test
    public void testRegularWork() {
        Assert.assertEquals(3, testClass.cutAfterLastFour(new int[]{1, 2, 3, 4, 6, 7, 8}).length);
    }
}
