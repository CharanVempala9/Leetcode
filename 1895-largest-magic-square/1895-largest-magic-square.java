class Solution {
    public boolean poss(int r,int c,int[][] grid,int k){
        int target = 0;
        for (int j = c; j < c + k; j++)
            target += grid[r][j];
        for (int i = r; i < r + k; i++) {
            int sum = 0;
            for (int j = c; j < c + k; j++)
                sum += grid[i][j];
            if (sum != target) return false;
        }
        for (int j = c; j < c + k; j++) {
            int sum = 0;
            for (int i = r; i < r + k; i++)
                sum += grid[i][j];
            if (sum != target) return false;
        }
        int diag1 = 0;
        for (int i = 0; i < k; i++)
            diag1 += grid[r + i][c + i];
        if (diag1 != target) return false;
        int diag2 = 0;
        for (int i = 0; i < k; i++)
            diag2 += grid[r + i][c + k - 1 - i];
        if (diag2 != target) return false;
        return true;
    }
    public int largestMagicSquare(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int max=1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for(int k=2; k+i<=n && k+j<=m; k++){
                    if(poss(i,j,grid,k)){
                        max=Math.max(max,k);
                    }
                }
            }
        }
        return max;
    }
}