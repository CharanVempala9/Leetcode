
public class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        LinkedHashMap<Integer, Integer> hm = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        int res = 0;
        int idx = 0;

        while (true) {
            boolean hasDuplicate = false;

            for (int val : hm.keySet()) {
                if (hm.get(val) > 1) {
                    hasDuplicate = true;
                    break;
                }
            }

            if (!hasDuplicate) {
                return res;
            }

            int cnt = 0;
            while (cnt < 3 && idx < n) {
                if (hm.containsKey(nums[idx]) && hm.get(nums[idx]) > 1) {
                    hm.put(nums[idx], hm.get(nums[idx]) - 1);
                } else {
                    hm.remove(nums[idx]);
                }
                idx++;
                cnt++;
            }
            res++;
        }
    }
}