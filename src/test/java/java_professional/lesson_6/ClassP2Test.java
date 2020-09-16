package java_professional.lesson_6;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ClassP2Test {
	private boolean expected;
	private int[] arg;

	private ClassP2 testClass;

	public ClassP2Test(boolean expected, int[] arg) {
		this.expected = expected;
		this.arg = arg;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{true, new int[]{1, 1, 1, 4, 4, 1, 4, 4}},
				{false, new int[]{1, 1, 1, 1, 1, 1, 1, 1}},
				{false, new int[]{4, 4, 4, 4, 4}},
				{false, new int[]{1, 1, 1, 4, 4, 1, 4, 4, 3}}
		});
	}

	@Before
	public void init() {
		testClass = new ClassP2();
	}

	@Test
	public void testRegularWork() {
		Assert.assertEquals(expected, testClass.isRight(arg));
	}
}
