class Solution {
    public int solve(int i, int j, int[][] grid, int k, int[][][] dp) {
        if (k < 0) return Integer.MIN_VALUE;
        if (i < 0 || j < 0) return Integer.MIN_VALUE;
        if (i == 0 && j == 0) {
            if (k >= 0) return 0;
            return Integer.MIN_VALUE;
        }
        if (dp[i][j][k] != -1) return dp[i][j][k];
        int cost = (grid[i][j] == 2 ? 1 : grid[i][j]);
        int up = grid[i][j] + solve(i - 1, j, grid, k - cost, dp);
        int left = grid[i][j] + solve(i, j - 1, grid, k - cost, dp);
        return dp[i][j][k] = Math.max(up, left);
    }
    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][k + 1];
        for (int x = 0; x < n; x++)
            for (int y = 0; y < m; y++)
                Arrays.fill(dp[x][y], -1);

        int ans = solve(n - 1, m - 1, grid, k, dp);
        return (ans < 0) ? -1 : ans;
    }
}
