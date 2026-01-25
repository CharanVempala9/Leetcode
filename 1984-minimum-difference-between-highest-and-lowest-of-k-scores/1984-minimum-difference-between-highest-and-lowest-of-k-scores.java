class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        for(int r=0; r<n-k+1; r++){
            int l=k+r-1;
            min=Math.min(nums[l]-nums[r],min);
        }
        return min;
    }
}