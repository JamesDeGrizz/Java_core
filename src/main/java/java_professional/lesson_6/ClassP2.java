package java_professional.lesson_6;

import java.util.HashMap;
import java.util.Map;

public class ClassP2 {

    public boolean isRight(int[] in) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < in.length; ++i) {
            int key = in[i];
            int value = map.containsKey(in[i]) ? map.get(in[i]) + 1 : 1;

            map.put(key, value);
        }
        return (map.size() == 2 && map.get(1) > 0 && map.get(4) > 0);
    }
}
