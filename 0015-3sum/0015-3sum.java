import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        HashSet<List<Integer>> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            HashSet<Integer> hs1 = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int temp = -1 * (nums[i] + nums[j]);
                if (hs1.contains(temp)) {
                    List<Integer> ls = Arrays.asList(nums[i], nums[j], temp);
                    Collections.sort(ls);
                    hs.add(ls);
                }
                hs1.add(nums[j]);
            }
        }
        return new ArrayList<>(hs);
    }
}
