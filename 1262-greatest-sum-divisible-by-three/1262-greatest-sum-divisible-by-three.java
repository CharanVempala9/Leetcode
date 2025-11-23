class Solution {
    public int can(int[] nums, int idx, int n, int rem, int[][] dp) {
        if (idx == n) {
            return rem == 0 ? 0 : Integer.MIN_VALUE;
        }
        if (dp[idx][rem] != Integer.MIN_VALUE) 
            return dp[idx][rem];
        int nottake = can(nums, idx + 1, n, rem, dp);
        int newRem = (rem + nums[idx] % 3) % 3;
        int take = nums[idx] + can(nums, idx + 1, n, newRem, dp);
        dp[idx][rem] = Math.max(take, nottake);
        return dp[idx][rem];
    }

    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        return can(nums, 0, n, 0, dp);
    }
}
