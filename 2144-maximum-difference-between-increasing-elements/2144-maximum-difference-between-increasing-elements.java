class Solution {
    public int maximumDifference(int[] nums) {
        int max=-1;
        int min=nums[0];
        int n=nums.length;
        for(int i=1; i<n; i++){
            if(nums[i-1]<nums[i]){
                max=Math.max(nums[i]-min,max);
            }
            min=Math.min(min,nums[i]);
        }
        return max;
    }
}