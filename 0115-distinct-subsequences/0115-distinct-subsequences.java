class Solution {
    public int rec(int i, int j, String s, String t,int[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j] !=-1) return dp[i][j];
        if(s.charAt(i)== t.charAt(j)){
            dp[i][j] = rec(i-1, j-1, s, t,dp) + rec(i-1, j, s, t,dp);
        }else
        dp[i][j] = rec(i-1, j, s, t,dp);
        return dp[i][j];
    }
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        return rec(n-1, m-1, s, t,dp);
    }
}