class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
    
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
    
        for (int i = 2; i < n; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    //rec
    // public int robber(int[] nums,int idx){
    //     if(idx<0)
    //         return 0;
    //     int rob=nums[idx]+robber(nums,idx-2);
    //     int notrob=robber(nums,idx-1);
    //     return Math.max(rob,notrob);
    // }
    // public int rob(int[] nums) {
    //     int n=nums.length-1;
    //     return robber(nums,n);
    // }

    //memoization
    //  public int robber(int[] nums,int idx,int[] dp){
    //     if(idx<0)
    //         return 0;
    //     if(dp[idx]!=-1)
    //     return dp[idx];
    //     int rob=nums[idx]+robber(nums,idx-2,dp);
    //     int notrob=robber(nums,idx-1,dp);
    //     dp[idx]=Math.max(rob,notrob);
    //     return dp[idx];
    // }
    // public int rob(int[] nums) {
    //     int n=nums.length-1;
    //     int dp[]=new int[n+1];
    //     Arrays.fill(dp,-1);
    //     return robber(nums,n,dp);
    // }

    //tabulation

//     public int rob(int[] nums) {
//     int n = nums.length;
//     if (n == 0) return 0;
//     if (n == 1) return nums[0];
    
//     int[] dp = new int[n];
//     dp[0] = nums[0];
//     dp[1] = Math.max(nums[0], nums[1]);
    
//     for (int i = 2; i < n; i++) {
//         dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
//     }
//     return dp[n - 1];
// }
}