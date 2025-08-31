class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int m = graph.length;
        boolean[] vi = new boolean[m];
        boolean[] chk = new boolean[m];
        boolean[] path = new boolean[m];

        for (int i = 0; i < m; i++) {
            if (!vi[i])
                isCycle(graph, vi, chk, path, m, i);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (chk[i])
                result.add(i);
        }
        return result;
    }

    boolean isCycle(int[][] graph, boolean[] vi, boolean[] chk, boolean[] path, int m, int i) {
        vi[i] = true;
        path[i] = true;
        for (int x : graph[i]) {
            if (!vi[x]) {
                if (isCycle(graph, vi, chk, path, m, x)) {
                    chk[i] = false;
                    return true;
                }
            } else if (path[x]) {
                chk[i] = false;
                return true;
            }

        }
        chk[i] = true;
        path[i] =false;
        return false;
    }

}