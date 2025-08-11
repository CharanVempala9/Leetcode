class Solution {
    public int[] productQueries(int n, int[][] queries) {
        java.util.List<Integer> powers = new java.util.ArrayList<>();
        for (int i = 0; i < 31; i++) {
            if ((n & (1 << i)) != 0) {
                powers.add(1 << i); 
            }
        }

        int m = queries.length;
        int MOD = 1_000_000_007;
        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            long prod = 1;
            for (int j = left; j <= right; j++) { 
                prod = (prod * powers.get(j)) % MOD;
            }
            ans[i] = (int) prod;
        }

        return ans;
    }
}
