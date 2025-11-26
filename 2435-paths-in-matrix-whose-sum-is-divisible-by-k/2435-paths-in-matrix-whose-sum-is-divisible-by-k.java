class Solution {
    int[][][] dp;
    int mod=1000000007;
    public int can(int[][] grid,int k,int r,int c,int sum){
        if(r>=grid.length || c>=grid[0].length){
            return 0;
        }
        sum=(grid[r][c]+sum)%k;
        if(r==grid.length-1 && c==grid[0].length-1){
            return sum==0 ? 1:0;
        }
        if(dp[r][c][sum]!=-1) return dp[r][c][sum];
        int right=can(grid,k,r,c+1,sum);
        int down=can(grid,k,r+1,c,sum);
        dp[r][c][sum]=(right+down)%mod;
        return dp[r][c][sum];
    }
    public int numberOfPaths(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        dp=new int[n][m][k];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for(int l=0; l<k; l++){
                    dp[i][j][l]=-1;
                }
            }
        }
        return can(grid,k,0,0,0);
    }
}