class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans=0;
        int n=nums.length;
        int l=0;
        long sum=0;
        for(int r=0; r<n; r++){
            sum+=nums[r];
            int len=r-l+1;
            while(sum*len>=k){
                sum-=nums[l];
                l++;
                len=r-l+1;
            }
            ans+=r-l+1;
        }
        return ans;
    }
}