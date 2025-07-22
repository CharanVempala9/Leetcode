class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int l = 0;
        int sum = 0;
        int max = 0;
        HashSet<Integer> hs = new HashSet<>();

        for (int r = 0; r < nums.length; r++) {
            while (hs.contains(nums[r])) {
                hs.remove(nums[l]);
                sum -= nums[l];
                l++;
            }
            hs.add(nums[r]);
            sum += nums[r];
            max = Math.max(max, sum);
        }

        return max;
    }
}
