class Solution {
    public int longestSubarray(int[] nums) {
        int cnt=2;
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=2; i<n; i++){
            if(nums[i-2]+nums[i-1]==nums[i]){
                cnt++;
            }
            else{
                cnt=2;
            }
            max=Math.max(max,cnt);
        }
        return max;
    }
}