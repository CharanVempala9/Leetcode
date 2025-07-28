class Solution {
    public int cnt(int idx, int[] coins, int amount,int[][] dp){
        if(idx==0){
            if(amount%coins[0]==0) return amount/coins[0];
            return (int)1e9;
        }
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        int repeat=Integer.MAX_VALUE;
        if(coins[idx]<=amount){
            repeat=1+cnt(idx,coins,amount-coins[idx],dp);
        }
        int not=cnt(idx-1,coins,amount,dp);
        dp[idx][amount] = Math.min(not,repeat);
        return dp[idx][amount];
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        int ans= cnt(n-1, coins, amount,dp);
        if(ans>= (int)1e9) return -1;
        return ans;
    }
}