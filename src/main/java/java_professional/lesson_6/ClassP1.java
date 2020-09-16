package java_professional.lesson_6;

import java.util.Arrays;

public class ClassP1 {

    public int[] cutAfterLastFour(int[] in) {

        for (int i = in.length - 1; i >= 0; --i) {
            if (in[i] == 4) {
                int[] res = Arrays.copyOfRange(in, i + 1, in.length);
                return Arrays.copyOfRange(in, i + 1, in.length);
            }
        }
        throw new RuntimeException("no 4 in input array");
    }
}
