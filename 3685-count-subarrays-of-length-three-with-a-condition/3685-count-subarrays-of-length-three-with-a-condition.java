class Solution {
    public int countSubarrays(int[] nums) {
        int cnt=0;
        for(int i=1; i<nums.length-1; i++){
            if((double)(nums[i-1]+nums[i+1])==(double)nums[i]/2)
            cnt++;
        }
        return cnt;
    }
}