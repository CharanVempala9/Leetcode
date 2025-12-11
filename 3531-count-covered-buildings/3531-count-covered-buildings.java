import java.util.*;

class Solution {
    public int countCoveredBuildings(int n, int[][] bd) {
        Map<Integer, TreeSet<Integer>> rows = new HashMap<>();
        Map<Integer, TreeSet<Integer>> cols = new HashMap<>();
        for (int[] b : bd) {
            rows.computeIfAbsent(b[0], x -> new TreeSet<>()).add(b[1]);
            cols.computeIfAbsent(b[1], x -> new TreeSet<>()).add(b[0]);
        }
        int cnt = 0;
        for (int[] b : bd) {
            int r = b[0], c = b[1];
            boolean up = cols.get(c).lower(r) != null;
            boolean down = cols.get(c).higher(r) != null;
            boolean left = rows.get(r).lower(c) != null;
            boolean right = rows.get(r).higher(c) != null;
            if (up && down && left && right) cnt++;
        }
        return cnt;
    }
}
