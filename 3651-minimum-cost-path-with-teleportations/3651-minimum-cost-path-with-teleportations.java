class Solution {
    public int minCost(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][k + 1];
        
        // Initialize DP array
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                for(int l = 0; l <= k; l++) {
                    dp[i][j][l] = (int)1e9;
                }
            }
        }
        
        int N = (int)1e4;
        int[] pbest = new int[N + 1];
        Arrays.fill(pbest, (int)1e9);
        
        // Process each teleportation level
        for(int l = 0; l <= k; l++) {
            int[] currbest = new int[N + 1];
            Arrays.fill(currbest, (int)1e9);
            
            // Process cells from bottom-right to top-left
            for(int i = m - 1; i >= 0; i--) {
                for(int j = n - 1; j >= 0; j--) {
                    // Base case: destination cell
                    if(i == m - 1 && j == n - 1) {
                        dp[i][j][l] = 0;
                    } 
                    // Transitions
                    else {
                        int mini = (int)1e9;
                        
                        // Move right
                        if(j + 1 < n) {
                            mini = Math.min(mini, grid[i][j + 1] + dp[i][j + 1][l]);
                        }
                        
                        // Move down  
                        if(i + 1 < m) {
                            mini = Math.min(mini, grid[i + 1][j] + dp[i + 1][j][l]);
                        }
                        
                        // Teleportation (if we have teleports left)
                        if(l > 0) {
                            // Can teleport to any cell with value <= grid[i][j]
                            mini = Math.min(mini, pbest[grid[i][j]]);
                        }
                        
                        dp[i][j][l] = mini;
                    }
                    
                    // Update current best for this cell's value
                    currbest[grid[i][j]] = Math.min(currbest[grid[i][j]], dp[i][j][l]);
                }
            }
            
            // Build prefix minimum array for next iteration
            pbest = new int[N + 1];
            Arrays.fill(pbest, (int)1e9);
            
            // Set pbest[i] = minimum of currbest[0] to currbest[i]
            if(currbest[0] != (int)1e9) {
                pbest[0] = currbest[0];
            }
            
            for(int i = 1; i <= N; i++) {
                pbest[i] = Math.min(pbest[i - 1], currbest[i]);
            }
        }
        
        return dp[0][0][k];
    }
}