class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int[] res=new int[nums.length];
        int n=nums.length;
        for(int i=0; i<n; i++){
            if(nums[i]>0){
                int idx=(i+nums[i])%n;
                res[i]=nums[idx];
            }
            else if(nums[i]<0){
                int idx=(i+nums[i])%n;
                if (idx < 0) {
                    idx += n;
                }
                res[i] = nums[idx];
            }
            else{
                res[i]=nums[i];
            }
        }
        return res;  
    }
}