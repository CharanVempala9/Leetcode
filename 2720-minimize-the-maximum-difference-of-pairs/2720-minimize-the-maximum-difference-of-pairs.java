class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0];
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isposs(nums, p, mid)) {
                result = mid; 
                right = mid - 1;
            } else {
                left = mid + 1; 
            }
        }

        return result;
    }

    private boolean isposs(int[] nums, int p, int maxDiff) {
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < p;) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                cnt++;
                i += 2; 
            } else {
                i++; 
            }
        }
        return cnt >= p;
    }
}
