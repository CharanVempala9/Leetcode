class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            max=Math.max(num,max);
        }
        int l=0;
        long ans=0;
        long cnt=0;
        int n=nums.length;
        for(int r=0; r<n; r++){
            if(nums[r]==max)
            cnt++;
            while(cnt>=k){
                if(cnt==k){
                    ans+=n-r;
                }   
                if(nums[l]==max)
                {
                    cnt--;
                }
                l++;
            }

        }
        return ans;
    }
}