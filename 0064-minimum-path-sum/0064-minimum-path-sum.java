class Solution {
    public int gen(int r,int c,int[][] grid,int[][] dp){
        if(r<0 || c<0){
            return Integer.MAX_VALUE;
        }
        if(r==0 && c==0){
            return grid[r][c];
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        int up =gen(r-1,c,grid,dp);
        int left =gen(r,c-1,grid,dp);

        int min=Math.min(left,up);
        dp[r][c]=  (min == Integer.MAX_VALUE) ? Integer.MAX_VALUE : grid[r][c] + min;
        return  dp[r][c];
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=gen(m-1,n-1,grid,dp);
        return ans;
    }
}

