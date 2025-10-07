import java.util.*;
class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        Map<Integer, Integer> lake = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (rains[i] != 0) {
                if (lake.containsKey(rains[i])) {
                    int pIdx = lake.get(rains[i]);
                    boolean find = false;
                    for (int j = pIdx; j < i; j++) {
                        if (rains[j] == 0) {
                            rains[j] = rains[i];
                            find = true;
                            break;
                        }
                    }
                    if (!find) return new int[0];
                    lake.put(rains[i], i);
                    rains[i] = -1;
                } else {
                    lake.put(rains[i], i);
                    rains[i] = -1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) rains[i] = 1;
        }
        return rains;
    }
}
