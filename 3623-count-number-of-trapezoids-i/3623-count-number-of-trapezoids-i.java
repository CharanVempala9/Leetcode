import java.util.*;

class Solution {
    public int countTrapezoids(int[][] points) {
        final int MOD = 1_000_000_007;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] point : points) {
            int y = point[1];
            map.put(y, map.getOrDefault(y, 0) + 1);
        }
        List<Long> segments = new ArrayList<>();
        for (int count : map.values()) {
            if (count >= 2) {
                long seg = ((long) count * (count - 1)) / 2;
                segments.add(seg);
            }
        }
        long totalSum = 0;
        long prefixSum = 0;
        for (long seg : segments) {
            totalSum = (totalSum + (prefixSum * seg) % MOD) % MOD;
            prefixSum = (prefixSum + seg) % MOD;
        }
        return (int) totalSum;
    }
}
