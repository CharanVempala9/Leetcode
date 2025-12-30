class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;

        for (int i = 0; i + 2 < n; i++) {
            for (int j = 0; j + 2 < m; j++) {
                if (isMagic(grid, i, j)) cnt++;
            }
        }
        return cnt;
    }

    public boolean isMagic(int[][] grid, int i, int j) {
        boolean[] seen = new boolean[10];
        for (int x = i; x < i + 3; x++) {
            for (int y = j; y < j + 3; y++) {
                int v = grid[x][y];
                if (v < 1 || v > 9 || seen[v]) return false;
                seen[v] = true;
            }
        }
        for (int x = 0; x < 3; x++) {
            int rsum = 0, csum = 0;
            for (int y = 0; y < 3; y++) {
                rsum += grid[i + x][j + y];
                csum += grid[i + y][j + x];
            }
            if (rsum != 15 || csum != 15) return false;
        }
        int d1 = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
        int d2 = grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j];
        return d1 == 15 && d2 == 15;
    }
}
