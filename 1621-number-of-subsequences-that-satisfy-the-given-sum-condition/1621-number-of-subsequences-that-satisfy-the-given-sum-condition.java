import java.util.*;

class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = 1000000007;
        int n = nums.length;
        Arrays.sort(nums);
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }

        int l = 0, r = n - 1;
        int count = 0;

        while (l <= r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else {
                count = (count + power[r - l]) % mod;
                l++;
            }
        }

        return count;
    }
}
