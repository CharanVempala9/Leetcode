class Solution {
    public boolean isposs(int[] nums,int i,int sum, Boolean[][]dp){
        if(sum==0) return true;
        if(i==0){
            return (nums[0]==sum);
        }
        if(dp[i][sum]!=null) return dp[i][sum];
        boolean notTake=isposs(nums,i-1,sum,dp);
        boolean take=false;
        if(nums[i]<=sum){
            take=isposs(nums,i-1,sum-nums[i],dp);
        }
        dp[i][sum] = notTake || take;
        return dp[i][sum];
    }
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int totSum=0;
        for(int i=0; i<n; i++){
            totSum+=nums[i];
        }
        if(totSum%2==1) return false;
        Boolean[][] dp=new Boolean[n][(totSum/2)+1];
        return isposs(nums,n-1,totSum/2,dp);
    }
}