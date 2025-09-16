import java.util.*;

class Pair {
    int r, c, wt;
    public Pair(int r, int c, int wt) {
        this.r = r;
        this.c = c;
        this.wt = wt;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[] rdir = {-1, 1, 0, 0};
        int[] cdir = {0, 0, -1, 1};
        int n = heights.length, m = heights[0].length;

        int[][] dist = new int[n][m];
        for (int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.offer(new Pair(0, 0, 0));
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int r = p.r, c = p.c, wt = p.wt;

            if (r == n - 1 && c == m - 1) return wt; 

            for (int i = 0; i < 4; i++) {
                int nr = r + rdir[i], nc = c + cdir[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int newEffort = Math.max(wt, Math.abs(heights[r][c] - heights[nr][nc]));
                    if (newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;
                        pq.offer(new Pair(nr, nc, newEffort));
                    }
                }
            }
        }
        return 0;
    }
}
