class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long ans = 0;
        long[] pfx = new long[n];
        pfx[0] = (long) prices[0] * strategy[0];
        ans = pfx[0];
        for (int i = 1; i < n; i++) {
            long tmp = (long) prices[i] * strategy[i];
            pfx[i] = pfx[i - 1] + tmp;
            ans += tmp;
        }
        for (int i = 0; i + k - 1 < n; i++) {
            long tmp = 0;
            int j = i;
            for (j = i + k / 2; j < i + k; j++) {
                tmp += prices[j];
            }
            long res = pfx[n - 1];
            res -= pfx[i + k - 1] - (i > 0 ? pfx[i - 1] : 0);
            res += tmp;
            ans = Math.max(ans, res);
        }
        return ans;
    }
}
