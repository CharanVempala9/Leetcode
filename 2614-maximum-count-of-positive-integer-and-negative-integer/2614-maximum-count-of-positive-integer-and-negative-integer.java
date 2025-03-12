class Solution {
    public int Bs(int[] nums,int k){
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
        int neg=Bs(nums,1);
        int pos=Bs(nums,0);
        int res=nums.length-neg;
        return Math.max(res,pos);
    }
}