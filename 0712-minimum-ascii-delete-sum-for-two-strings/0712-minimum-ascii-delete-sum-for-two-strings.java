class Solution {
    int[][] dp;
    public int LCS(int i, int j, String s1, String s2) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }
        if (dp[i][j] != -1) return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = s1.charAt(i) + LCS(i + 1, j + 1, s1, s2);
        } else {
            dp[i][j] = Math.max(
                LCS(i + 1, j, s1, s2),
                LCS(i, j + 1, s1, s2)
            );
        }
        return dp[i][j];
    }
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        dp = new int[n][m];
        for (int[] row : dp)
            java.util.Arrays.fill(row, -1);
        int sum1 = 0, sum2 = 0;
        for (char c : s1.toCharArray()) sum1 += c;
        for (char c : s2.toCharArray()) sum2 += c;
        int lcsSum = LCS(0, 0, s1, s2);
        return sum1 + sum2 - 2 * lcsSum;
    }
}
