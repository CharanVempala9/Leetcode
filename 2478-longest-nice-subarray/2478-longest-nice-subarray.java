class Solution {
    public int longestNiceSubarray(int[] nums) {
        int l = 0;
        int currMask = 0;
        int max = 0;
        for (int r = 0; r < nums.length; r++) {
            while ((currMask & nums[r]) != 0) {
                currMask ^= nums[l]; 
                l++;
            }
            currMask |= nums[r];
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
