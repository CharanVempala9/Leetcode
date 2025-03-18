class Solution {
    public int longestNiceSubarray(int[] nums) {
        int l = 0;
        int n = nums.length;
        int max = 1; 

        for (int r = 1; r < n; r++) {
            boolean conflict = false;
            for (int k = l; k < r; k++) {
                if ((nums[k] & nums[r]) != 0) {
                    conflict = true;
                    break;
                }
            }

            if (conflict) {
                while (l < r) {
                    boolean foundConflict = false;
                    for (int k = l + 1; k < r; k++) {
                        if ((nums[k] & nums[r]) != 0) {
                            foundConflict = true;
                            break;
                        }
                    }
                    l++;
                    if (!foundConflict) break;
                }
            }

            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}
