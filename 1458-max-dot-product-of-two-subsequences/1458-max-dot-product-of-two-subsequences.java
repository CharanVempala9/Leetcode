class Solution {

    public int can(int i, int j, int[] nums1, int[] nums2, int[][] dp) {
        if (i >= nums1.length || j >= nums2.length) {
            return Integer.MIN_VALUE;
        }
        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }
        int prod = nums1[i] * nums2[j];
        int take = prod;
        int next = can(i + 1, j + 1, nums1, nums2, dp);
        if (next != Integer.MIN_VALUE) {
            take = Math.max(take, prod + next);
        }
        int skipNums2 = can(i, j + 1, nums1, nums2, dp);
        int skipNums1 = can(i + 1, j, nums1, nums2, dp);
        dp[i][j] = Math.max(take, Math.max(skipNums1, skipNums2));
        return dp[i][j];
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        return can(0, 0, nums1, nums2, dp);
    }
}
