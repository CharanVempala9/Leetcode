import java.util.*;

class Solution {
    Map<String, Integer> dp = new HashMap<>();

    private int solve(long num1, long num2, int k) {
        String key = num1 + "," + k;
        if (dp.containsKey(key)) return dp.get(key);

        long m = num1 - k * num2;
        if (m < k) return (int)1e9; 
        if (Long.bitCount(m) <= k) return k;
        int ans = solve(num1, num2, k + 1);

        dp.put(key, ans);
        return ans;
    }

    public int makeTheIntegerZero(int num1, int num2) {
        int ans = solve(num1, num2, 1);
        return ans >= 1e9 ? -1 : ans;
    }
}
