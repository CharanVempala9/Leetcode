class Solution {
    public int minRemoval(int[] nums, int k) {
        if(nums.length==1)return 0;
        Arrays.sort(nums);
        int l=0;
        int n=nums.length;
        int max=0;
        for(int r=0; r<n; r++){
            while(nums[l]*1L*k<nums[r]){
                l++;
            }
            max=Math.max(max,r-l+1);
        }
        return n-max;
    }
}
/* 1 2 5

    5 11 20


   

   1 2 


   


*/