class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans=0;
        int n=nums.length;
        int l=0;
        long cnt=0;
        for(int r=0; r<n; r++){
            if(nums[r]==0){
                cnt=r-l+1;
            }
            else{
                //System.out.println(l+" "+r+" "+cnt);
                ans+=(cnt*(cnt+1))/2;
                cnt=0;
                l=r+1;
            }
        }
        ans+=(cnt*(cnt+1))/2;
        return ans;
    }
}