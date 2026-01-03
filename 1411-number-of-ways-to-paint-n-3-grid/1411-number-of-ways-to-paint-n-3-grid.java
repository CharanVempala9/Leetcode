class Solution {
    public int numOfWays(int n) {
        int MOD = 1000000007;
        long a1 = 6, a2 = 6;
        for (int i = 2; i <= n; i++) {
            long newa1 = (3 * a1 + 2 * a2) % MOD;
            long newa2 = (2 * a1 + 2 * a2) % MOD;
            a1 = newa1;
            a2 = newa2;
        }
        return (int)((a1 + a2) % MOD);
    }
}