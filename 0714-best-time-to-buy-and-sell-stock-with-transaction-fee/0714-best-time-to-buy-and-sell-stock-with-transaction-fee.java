class Solution {
    public int rec(int idx, int buy, int[] prices, int fee,int[][] dp){
        if(idx==prices.length){
            return 0;
        }
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        int profit=0;
        if(buy==1){
            profit = Math.max(-prices[idx] + rec(idx+1, 0, prices, fee,dp) , rec(idx+1, 1, prices, fee,dp));
        }
        else{
            profit = Math.max(prices[idx] - fee + rec(idx+1 , 1, prices, fee,dp), rec(idx+1, 0, prices, fee,dp));
        }
        dp[idx][buy] = profit;
        return dp[idx][buy];
    }
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        return rec(0, 1, prices, fee,dp);
    }
}