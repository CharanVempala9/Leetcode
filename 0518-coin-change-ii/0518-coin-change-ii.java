class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount + 1];

        for (int a = 0; a <= amount; a++) {
            if (a % coins[0] == 0)
                prev[a] = 1;
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[amount + 1];
            for (int a = 0; a <= amount; a++) {
                int notTake = prev[a];
                int take = 0;
                if (coins[i] <= a)
                    take = curr[a - coins[i]];
                curr[a] = take + notTake;
            }
            prev = curr;
        }

        return prev[amount];
    }
}
