class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int totalSum = 0;
        for (int[] row : grid) {
            for (int val : row) {
                totalSum += val;
            }
        }

        int[] rowSums = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSums[i] += grid[i][j];
            }
        }

        int currSum = 0;
        for (int i = 0; i < m - 1; i++) { 
            currSum += rowSums[i];
            if (currSum * 2 == totalSum) {
                return true;
            }
        }

        int[] colSums = new int[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                colSums[j] += grid[i][j];
            }
        }

        currSum = 0;
        for (int j = 0; j < n - 1; j++) { 
            currSum += colSums[j];
            if (currSum * 2 == totalSum) {
                return true;
            }
        }

        return false;
    }
}
