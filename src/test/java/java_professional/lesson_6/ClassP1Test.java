package java_professional.lesson_6;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ClassP1Test {
    private int[] expected;
    private int[] arg;

    private ClassP1 testClass;

    public ClassP1Test(int[] expected, int[] arg) {
        this.expected = expected;
        this.arg = arg;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[]{6, 7, 8}, new int[]{1, 2, 3, 4, 6, 7, 8}},
                {new int[]{6, 7, 8}, new int[]{4, 6, 7, 8}},
                {new int[]{}, new int[]{1, 2, 3, 4}}
        });
    }

    @Before
    public void init() {
        testClass = new ClassP1();
    }

    @Test
    public void testRegularWork() {
        Assert.assertArrayEquals(expected, testClass.cutAfterLastFour(arg));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testExceptions() {
        thrown.expect(RuntimeException.class);
        testClass.cutAfterLastFour(new int[]{1, 2, 3, 5, 6, 7, 8});

        thrown.expect(NullPointerException.class);
        testClass.cutAfterLastFour(null);
    }
}
