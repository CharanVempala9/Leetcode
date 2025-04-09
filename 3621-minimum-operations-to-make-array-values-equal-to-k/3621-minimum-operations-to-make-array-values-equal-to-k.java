import java.util.*;

class Solution {
    public int minOperations(int[] nums, int k) {
        for (int num : nums) {
            if (num < k) return -1;  
        }
        Set<Integer> hs = new HashSet<>();
        for (int num : nums) {
            if (num > k) hs.add(num);
        }

        return hs.size();
    }
}