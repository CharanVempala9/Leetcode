class Solution {
    public long dfs(int node, int parent, int[] val, int k, List<List<Integer>> adj, int[] cnt) {
        long sum = val[node];
        for (int nxt : adj.get(node)) {
            if (nxt != parent) {
                sum += dfs(nxt, node, val, k, adj, cnt);
            }
        }
        if (sum % k == 0) {
            cnt[0]++;
            return 0;
        }
        return sum;
    }

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int[] cnt = new int[1];
        dfs(0, -1, values, k, adj, cnt);
        return cnt[0];
    }
}
