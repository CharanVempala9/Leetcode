class Solution {
    // public int rec(int idx, int buy, int [] prices, int k,int[][][] dp){
    //     if(k==0 || idx==prices.length) return 0;
    //     if(dp[idx][buy][k] !=-1 ) return dp[idx][buy][k];
    //     int profit=0;
    //     if(buy==1){
    //         profit = Math.max(-prices[idx] + rec(idx+1, 0, prices, k,dp) , rec(idx+1, 1, prices, k,dp) );
    //     }
    //     else{
    //         profit= Math.max(rec(idx+1, 0, prices, k,dp), prices[idx]+ rec(idx+1, 1, prices, k-1,dp));
    //     }
    //     dp[idx][buy][k]=profit;
    //     return dp[idx][buy][k];
    // }
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][k+1];
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<2; j++){
        //         Arrays.fill(dp[i][j],-1);
        //     }
        // }
        // return rec(0, 1, prices, k,dp);
        for(int idx=n-1; idx>=0; idx--){
            for(int buy=0; buy<2; buy++){
                for(int t=1; t<=k; t++){
                    if(buy==1){
                        dp[idx][buy][t] = Math.max(-prices[idx] + dp[idx+1][0][t], dp[idx+1][1][t]);
                    }
                    else{
                        dp[idx][buy][t] =Math.max(prices[idx] + dp[idx+1][1][t-1] , dp[idx+1][0][t]);
                    }
                }
            }
        }
        return dp[0][1][k];
    }
}