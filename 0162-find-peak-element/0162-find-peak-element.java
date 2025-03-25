class Solution {
    public int findPeakElement(int[] nums) {
        int l=0;
        int h=nums.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(mid<nums.length-1 && nums[mid]<=nums[mid+1]){
                l=mid+1;
            }
            else{
                 h=mid-1;
            }
        }
        return l;
    }
}