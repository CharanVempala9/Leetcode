class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return isposs(1,n,delay,forget,dp);
    }
    public int isposs(int days,int n,int delay,int forget,int[] dp){
        if(days>n) return 0;
        if(dp[days]!=-1) return dp[days];
        long res = 0;
        if (days + forget > n) {
            res = 1;
        }
        for(int i=days+delay; i<days+forget && i<=n; i++){
            res+=isposs(i,n,delay,forget,dp);
            res%=(int)1000000007;
        }
        dp[days] = (int)res;
        return dp[days];
    }
}