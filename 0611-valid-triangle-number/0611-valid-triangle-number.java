class Solution {
    public int triangleNumber(int[] nums) {
        int n=nums.length;
        int cnt=0;
        Arrays.sort(nums);
        for (int k = n - 1; k >= 2; k--) { 
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    cnt += (j - i);   
                    j--;
                } else {
                    i++;
                }
            }
        }
        return cnt;
    }
}