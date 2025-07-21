class Solution {
    public int generate(int r,int c,int[][] grid,int[][] dp){
        if(r<0 || c<0){
            return 0;
        }
        if(r>=0 && c>=0 && grid[r][c]==1) {
            return 0;
        }
        if(r==0 && c==0){
            dp[r][c]=1;
            return 1;
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        int up=generate(r-1,c,grid,dp);
        int left=generate(r,c-1,grid,dp);
        dp[r][c]= up+left;
        return dp[r][c];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
        return 0;
        int[][] dp=new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i],-1);
        }
        int cnt=generate(m-1,n-1,obstacleGrid,dp);
        return dp[m-1][n-1];
    }
}