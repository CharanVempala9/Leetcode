class Solution {
    public int generate(int r,int c,int[][] dp){
        if(r<0 || c<0){
            return 0;
        }
        if(r==0 && c==0){
            dp[r][c]=1;
            return 1;
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        int up=generate(r-1,c,dp);
        int left=generate(r,c-1,dp);
        dp[r][c]= up+left;
        return dp[r][c];
    }
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);  
        }
        int cnt=generate(m-1,n-1,dp);
        return dp[m-1][n-1];
    }
}