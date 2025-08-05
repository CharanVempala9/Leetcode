class Solution {
    public int rec(int idx, int prev,int[] nums, int[][] dp){
        if(idx==nums.length){
            return 0;
        }
        if(dp[idx][prev+1]!=-1) return dp[idx][prev+1];
        int take=0;
        int notTake=0;
        if(prev == -1 || nums[idx] > nums[prev]){
            take = 1 + rec(idx+1, idx , nums,dp);
        }
        notTake = rec(idx+1, prev , nums, dp);
        dp[idx][prev+1] = Math.max(take, notTake);
        return dp[idx][prev+1];

    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        return rec(0,-1,nums,dp);
    }
}