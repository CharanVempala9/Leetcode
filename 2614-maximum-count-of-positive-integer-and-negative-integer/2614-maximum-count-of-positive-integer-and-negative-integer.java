class Solution {
    public static int BS2(int[] nums, int k){
        int l=0;
        int h=nums.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]>=k){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    public int maximumCount(int[] nums) {
        int n=nums.length;
        int c1=BS2(nums,1);
        int c2=BS2(nums,0);
        int res1=n-c1;
        return Math.max(res1,c2);
    }
}