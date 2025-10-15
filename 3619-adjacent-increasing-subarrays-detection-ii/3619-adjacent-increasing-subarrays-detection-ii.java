class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int[] pre = new int[n];
        int[] sff = new int[n];
        pre[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums.get(i - 1) < nums.get(i)) {
                pre[i] = pre[i - 1] + 1;
            } else {
                pre[i] = 1;
            }
        }
        sff[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) {
                sff[i] = sff[i + 1] + 1;
            } else {
                sff[i] = 1;
            }
        }
        int max = 0;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, Math.min(pre[i - 1], sff[i]));
        }
        return max;
    }
}