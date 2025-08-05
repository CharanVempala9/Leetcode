class Solution {
    // public int rec(int idx, int buy, int[] prices, int[][] dp){
    //     if(idx>=prices.length){
    //         return 0;
    //     }
    //     if(dp[idx][buy]!=-1) return dp[idx][buy];
    //     int profit=0;
    //     if(buy==1){
    //         profit= Math.max(-prices[idx] + rec(idx+1, 0, prices, dp) , rec(idx+1, 1, prices,dp));
    //     }
    //     else{
    //         profit = Math.max( prices[idx] + rec(idx+2, 1, prices,dp), rec(idx+1, 0, prices,dp));
    //     }
    //     dp[idx][buy]=  profit;
    //     return dp[idx][buy];
    // }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][2];
        // for(int i=0; i<n; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // return rec(0, 1, prices, dp);
        for(int i=n-1; i>=0; i--){
            for(int buy=0; buy<2; buy++){
                if(buy==1){
                    dp[i][buy] =Math.max(-prices[i] + dp[i+1][0] , dp[i+1][1]); 
                }
                else{
                    int cooldown = prices[i];
                    if(i+2<=n){
                        cooldown += dp[i+2][1];
                    }
                    int notbuy = dp[i+1][0];
                    dp[i][buy]= Math.max(notbuy , cooldown);
                }
            }
        }
        return dp[0][1];
    }
}