class Solution {
    public static boolean ispossible(int[] nums, int k, int mid) {
        int sum = 0;
        int cnt = 1; 

        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > mid) { 
                sum = 0;
                cnt++;  
                if (cnt > k) return false;
            }
            sum += nums[i]; 
        }
        return cnt <= k;
    }

    public int splitArray(int[] nums, int k) {
        int l = 0, h = 0;
        for (int num : nums) {
            l = Math.max(l, num); 
            h += num; 
        }

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (ispossible(nums, k, mid)) {
                h = mid - 1; 
            } else {
                l = mid + 1; 
            }
        }
        return l;
    }
}
