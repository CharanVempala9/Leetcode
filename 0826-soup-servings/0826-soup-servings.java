class Solution {
    public double rec(int A, int B, double[][] dp){
        if(A<=0 && B<=0){
            return 0.5;
        }
        if(A<=0){
            return 1;
        }
        if(B<=0){
            return 0;
        }
        if(dp[A][B] !=-1) return dp[A][B];
        dp[A][B] = 0.25*(rec(A-100 , B, dp) + rec(A-75, B-25, dp) + rec(A-50, B-50,dp) + rec(A-25, B-75,dp));
        return dp[A][B];
    }
    public double soupServings(int n) {
        if(n>4800) return 1;
        double[][] dp=new double[n+1][n+1];
        for(int i=0; i<n+1; i++){
            Arrays.fill(dp[i] , -1);
        }
        return rec(n, n,dp);
    }
}