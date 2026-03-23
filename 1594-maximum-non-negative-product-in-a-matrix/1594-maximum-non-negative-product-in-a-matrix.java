class Solution {
    int m = 0;
    int n = 0;
    static final int MOD = 1000000007;
    long product = -1;
    private void solve(int[][] grid, int i, int j, long curr) {
        if (i == m - 1 && j == n - 1) {
            product = Math.max(product, curr * grid[i][j]);
            return;
        }
        // Note: pruning to remove TLE. Any exploration after a 0 is found is not worth
        // as the product will be 0. 
        if (grid[i][j] == 0) {
            product = Math.max(product, 0);
            return;
        }
        curr = curr * grid[i][j];
        if (i + 1 < m) {
            solve(grid, i + 1, j, curr);
        }
        if (j + 1 < n) {
            solve(grid, i, j + 1, curr);
        }
    }
    public int maxProductPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        solve(grid, 0, 0, 1);
        return product < 0 ? -1 : (int) (product % MOD);
    }
}