class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int l=0;
        int n=nums.length;
        int max=0;
        int ans=0;
        for(int r=0; r<n; r++){
            if(nums[r]-nums[l]<=1)
            ans=r-l+1;
            else{
                l++;
            }
            if(nums[r]!=nums[l] && nums[r]-nums[l]==1)
            max=Math.max(ans,max);
        }
        return max;
    }
}