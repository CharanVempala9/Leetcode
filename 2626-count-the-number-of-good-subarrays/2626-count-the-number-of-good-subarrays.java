class Solution {
    public long countGood(int[] nums, int k) {
        long ans = 0;
        int n = nums.length;
        int l = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        long cnt = 0;

        for (int r = 0; r < n; r++) {
            int val = hm.getOrDefault(nums[r], 0);
            cnt += val;  
            hm.put(nums[r], val + 1);

            while (cnt >= k && l <= r) {
                ans += (n - r); 
                int temp = hm.get(nums[l]);
                cnt -= (temp - 1);
                hm.put(nums[l], temp - 1);
                if (hm.get(nums[l]) == 0) hm.remove(nums[l]);
                l++;
            }
        }

        return ans;
    }
}
