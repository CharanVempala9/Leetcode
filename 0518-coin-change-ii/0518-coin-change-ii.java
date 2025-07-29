class Solution {
    public int  gen(int idx, int[] coins, int amount,int[][] dp){
        if(idx==0){
            if(amount==0) return 1;
            if(amount % coins[0]== 0) return 1;
            return 0;
        }
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        int take=0;
        if(coins[idx]<=amount){
            take=gen(idx,coins,amount-coins[idx],dp);
        }
        int notTake=gen(idx-1, coins,amount,dp);
        dp[idx][amount]= take+notTake;
        return dp[idx][amount];
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i],-1);
        return gen(n-1, coins,amount,dp);
    }
}