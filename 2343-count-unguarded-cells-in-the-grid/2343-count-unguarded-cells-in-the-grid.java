class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] vis = new int[m][n];
        for (int[] w : walls) vis[w[0]][w[1]] = 3;
        for (int[] g : guards) vis[g[0]][g[1]] = 2;
        for (int[] g : guards) {
            int x = g[0], y = g[1];
            for (int i = x + 1; i < m && vis[i][y] != 3 && vis[i][y] != 2; i++)
                if (vis[i][y] == 0) vis[i][y] = 1;
            for (int i = x - 1; i >= 0 && vis[i][y] != 3 && vis[i][y] != 2; i--)
                if (vis[i][y] == 0) vis[i][y] = 1;
            for (int j = y - 1; j >= 0 && vis[x][j] != 3 && vis[x][j] != 2; j--)
                if (vis[x][j] == 0) vis[x][j] = 1;
            for (int j = y + 1; j < n && vis[x][j] != 3 && vis[x][j] != 2; j++)
                if (vis[x][j] == 0) vis[x][j] = 1;
        }
        int cnt = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (vis[i][j] == 0) cnt++;
        return cnt;
    }
}
