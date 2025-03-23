import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        long[] ways = new long[n];
        ways[0] = 1;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[]{0, 0}); // start from node 0 with time 0

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int node = (int) curr[0];
            long time = curr[1];
            if (time > dist[node]) continue;
            for (int i = 0; i < roads.length; i++) {
                int u = roads[i][0];
                int v = roads[i][1];
                int t = roads[i][2];

                if (u == node || v == node) {
                    int next = (u == node) ? v : u;
                    long newTime = time + t;

                    if (newTime < dist[next]) {
                        dist[next] = newTime;
                        ways[next] = ways[node];
                        pq.offer(new long[]{next, newTime});
                    } else if (newTime == dist[next]) {
                        ways[next] = (ways[next] + ways[node]) % MOD;
                    }
                }
            }
        }

        return (int) (ways[n - 1] % MOD);
    }
}
