class Solution {
    public int rec(int idx, int[] nums,int sum,int[][] dp){
        if(idx==0){
            if(sum==0 && nums[0]==sum) return 2;
            if(sum==0 || nums[0]==sum) return 1;
            return 0;
        }
        if(dp[idx][sum]!=-1) return dp[idx][sum];
        int notTake= rec(idx-1, nums, sum,dp);
        int take=0;
        if(nums[idx]<=sum){
            take=rec(idx-1,nums,sum-nums[idx],dp);
        }
        dp[idx][sum]= take+notTake;
        return  dp[idx][sum];

    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int totSum=0;
        for(int num:nums){
            totSum+=num;
        }
        if((totSum-target)<0 || (totSum-target)%2==1) return 0;
        int sum=(totSum-target)/2;
        int[][] dp=new int[n][sum+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        return rec(n-1, nums, sum,dp);
    }
}