class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int maxEle=0;
        for(int i=0; i<n; i++){
            maxEle=Math.max(maxEle,nums[i]);
        }
        int ans=1;
        int cnt=1;
        for(int i=1; i<n; i++){
            if(nums[i-1]==nums[i] && nums[i]==maxEle){
                cnt++;
            }
            else{
                cnt=1;
            }
            ans=Math.max(ans,cnt);
        }
        return ans;
    }
}