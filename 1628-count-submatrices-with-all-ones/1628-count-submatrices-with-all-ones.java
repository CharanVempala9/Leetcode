class Solution {
    public int numSubmat(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // Step 1: compute heights
        int[][] height = new int[n][m];
        for (int j = 0; j < m; j++) {
            height[0][j] = mat[0][j];
            for (int i = 1; i < n; i++) {
                height[i][j] = (mat[i][j] == 1) ? height[i-1][j] + 1 : 0;
            }
        }

        int ans = 0;

        // Step 2: row by row histogram logic
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (height[i][j] > 0) {
                    int minH = height[i][j];
                    for (int k = j; k >= 0 && height[i][k] > 0; k--) {
                        minH = Math.min(minH, height[i][k]);
                        ans += minH; // count rectangles ending at (i, j) with left bound k
                    }
                }
            }
        }

        return ans;
    }
}
