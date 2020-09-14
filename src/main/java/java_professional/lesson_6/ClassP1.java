package java_professional.lesson_6;

import java.util.Arrays;

public class ClassP1 {

    public int[] cutAfterLastFour(int[] in) {

        for (int i = in.length - 1; i > 0; --i) {
            if (in[i] == 4) {
                return Arrays.copyOfRange(in, i, in.length);
            }
        }
        throw new RuntimeException("no 4 in input array");
    }
}
