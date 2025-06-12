class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max=0;
        int n = nums.length;
        for(int i=1;i<n+1;i++){
            max = Math.max(max, Math.abs(nums[(i-1)%n]-nums[i%n]));
        }
        return max;
    }
}