class Solution {

    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int size) {
            parent = new int[size + 1];
            rank = new int[size + 1];
            for (int i = 1; i <= size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int u) {
            if (parent[u] != u) {
                parent[u] = find(parent[u]);
            }
            return parent[u];
        }

        public void union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            if (rootU == rootV)
                return;

            if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else if (rank[rootV] < rank[rootU]) {
                parent[rootV] = rootU;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {

        UnionFind uf = new UnionFind(c);

        for (int[] conn : connections) {
            uf.union(conn[0], conn[1]);
        }

        Map<Integer, TreeSet<Integer>> onlineGrid = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int root = uf.find(i);
            onlineGrid.putIfAbsent(root, new TreeSet<>());
            onlineGrid.get(root).add(i);
        }

        boolean[] isOnline = new boolean[c + 1];
        Arrays.fill(isOnline, true);
        
        List<Integer> res = new ArrayList<>();
        for (int[] query : queries) {
            int type = query[0];
            int x = query[1];

            if (type == 1) {
                if (isOnline[x]) {
                    res.add(x);
                } else {
                    int root = uf.find(x);
                    TreeSet<Integer> onlineSet = onlineGrid.get(root);
                    if (onlineSet == null || onlineSet.isEmpty()) {
                        res.add(-1);
                    } else {
                        res.add(onlineSet.first());
                    }
                }
            } else if (type == 2) {
                if (isOnline[x]) {
                    isOnline[x] = false;
                    int root = uf.find(x);
                    onlineGrid.get(root).remove(x);
                }
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}