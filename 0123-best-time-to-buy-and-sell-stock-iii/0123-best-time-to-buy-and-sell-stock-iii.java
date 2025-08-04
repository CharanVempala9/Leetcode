class Solution {
    public int rec(int idx, int buy, int[] prices , int t, int[][][] dp){
        if(t==2 || idx==prices.length){
            return 0;
        }
        if(dp[idx][buy][t] !=-1) return dp[idx][buy][t];
        int profit=0;
        if(buy==1){
            profit = Math.max(-prices[idx] + rec(idx+1, 0, prices , t,dp) , rec(idx+1, 1, prices, t,dp));
        }
        else{
            profit = Math.max(prices[idx] + rec(idx+1, 1, prices, t+1,dp), rec(idx+1, 0, prices, t,dp));
        }
        dp[idx][buy][t] = profit;
        return dp[idx][buy][t];
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n][2][3];
        for(int i=0; i<n; i++){
            for(int j=0; j<=1; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return rec(0,1,prices,0,dp);
    }
}