class Solution {
    // public int generate(int r,int c,int[][] dp){
    //     if(r<0 || c<0){
    //         return 0;
    //     }
    //     if(r==0 && c==0){
    //         dp[r][c]=1;
    //         return 1;
    //     }
    //     if(dp[r][c]!=-1){
    //         return dp[r][c];
    //     }
    //     int up=generate(r-1,c,dp);
    //     int left=generate(r,c-1,dp);
    //     dp[r][c]= up+left;
    //     return dp[r][c];
    // }
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);  
        }
        dp[0][0]=1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0) dp[0][0]=1;
                else{
                    int up=0;
                    int left=0;
                    if(i>0) up=dp[i-1][j];
                    if(j>0) left=dp[i][j-1];
                    dp[i][j]=up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }
}