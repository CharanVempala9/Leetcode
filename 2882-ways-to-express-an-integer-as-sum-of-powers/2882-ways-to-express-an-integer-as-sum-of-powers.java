class Solution {
    public int rec(int n, int x, int cnt, int overflow, int[][] dp) {
        if (n < 0 || cnt - 1 > overflow) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (dp[n][cnt] != -1) return dp[n][cnt];

        int take = 0;
        int nottake = 0;
        int p = (int) Math.pow(cnt, x);

        if (n - p >= 0) {
            take = rec(n - p, x, cnt + 1, overflow, dp);
        }
        nottake = rec(n, x, cnt + 1, overflow, dp);

        dp[n][cnt] = (take + nottake) % (int)(1e9+7);
        return dp[n][cnt];
    }

    public int numberOfWays(int n, int x) {
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return rec(n, x, 1, n, dp);
    }
}
