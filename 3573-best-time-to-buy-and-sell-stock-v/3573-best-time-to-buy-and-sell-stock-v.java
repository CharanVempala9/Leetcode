class Solution {
    public long can(int[] prices, int idx, int k, int b, long val, Long[][][] dp) {
        if (idx == prices.length || k == 0) {
            if (b == 0) return val;
            return Long.MIN_VALUE;
        }
        if (dp[idx][k][b + 1] != null) {
            if (dp[idx][k][b + 1] == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return dp[idx][k][b + 1] + val;
        }
        long take = Long.MIN_VALUE;
        if (b == 0) {
            take = Math.max(
                can(prices, idx + 1, k, 1, val - prices[idx], dp),
                can(prices, idx + 1, k, -1, val + prices[idx], dp)
            );
        }
        else if (b == 1) {
            take = can(prices, idx + 1, k - 1, 0, val + prices[idx], dp);
        }
        else {
            take = can(prices, idx + 1, k - 1, 0, val - prices[idx], dp);
        }
        long ntake = can(prices, idx + 1, k, b, val, dp);
        long best = Math.max(take, ntake);
        dp[idx][k][b + 1] = (best == Long.MIN_VALUE) ? Long.MIN_VALUE : best - val;
        return best;
    }
    public long maximumProfit(int[] prices, int k) {
        Long[][][] dp = new Long[prices.length][k + 1][3];
        return can(prices, 0, k, 0, 0, dp);
    }
}
/*
    //at any idx i have to perform two operations
        1.either buying a stock
        2.or selling a stock
    these two can be selected to achieve maximum profit.......
    Then howwwwwwwww..?
    at every idx i do both ops.... if buy -1 or sell -1. initially it will be 2. it if comes 0 then total transcation is complted. otherwise not.....
    then how can i set back to 2..



*/