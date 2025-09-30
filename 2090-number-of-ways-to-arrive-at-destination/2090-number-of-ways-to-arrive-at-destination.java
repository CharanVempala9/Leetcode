class Pair {
    int n;
    long t;
    public Pair(int n, long t) {
        this.n = n;
        this.t = t;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] r : roads) {
            int u = r[0], v = r[1], time = r[2];
            adj.get(u).add(new Pair(v, time));
            adj.get(v).add(new Pair(u, time));
        }
        long[] dist = new long[n];
        long[] ways = new long[n];  
        Arrays.fill(dist, Long.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.t, b.t));
        int MOD = 1_000_000_007;
        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.n;
            long time = p.t;
            for (Pair it : adj.get(node)) {
                int adjnode = it.n;
                long ntime = it.t + time;

                if (ntime < dist[adjnode]) {
                    dist[adjnode] = ntime;
                    pq.offer(new Pair(adjnode, ntime));
                    ways[adjnode] = ways[node];
                } else if (ntime == dist[adjnode]) {
                    ways[adjnode] = (ways[adjnode] + ways[node]) % MOD;
                }
            }
        }
        return (int)(ways[n - 1] % MOD);
    }
}
