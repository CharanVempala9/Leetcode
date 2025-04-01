class Solution {
    public int countHillValley(int[] nums) {
        int cnt=0;
        int n=nums.length;
        int left=nums[0];
        for(int i=1; i<n-1; i++){
            if(left>nums[i] && nums[i+1]>nums[i]){
                cnt++;
                left=nums[i];
            }
            else if(left<nums[i] && nums[i+1]<nums[i]){
                cnt++;
                left=nums[i];
            }
        }
        return cnt;
    }
}