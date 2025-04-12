class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1; 
        int result = 0;

        for (int bit = 0; bit < 32; bit++) {
            int mask = 1 << bit;
            int countNums = 0;
            int countExpected = 0;

            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] & mask) != 0) {
                    countNums++;
                }
            }

            for (int i = 1; i <= n; i++) {
                if ((i & mask) != 0) {
                    countExpected++;
                }
            }

            if (countNums > countExpected) {
                result |= mask;
            }
        }

        return result;
    }
}
