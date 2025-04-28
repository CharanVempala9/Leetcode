class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans=0;
        int n=nums.length;
        int l=0;
        long sum=0;
        ArrayList<Integer>ls=new ArrayList<>();
        for(int r=0; r<n; r++){
            sum+=nums[r];
            ls.add(nums[r]);
            while(sum*ls.size()>=k){
                sum-=nums[l];
                ls.remove(0);
                l++;
            }
            ans+=r-l+1;
        }
        return ans;
    }
}