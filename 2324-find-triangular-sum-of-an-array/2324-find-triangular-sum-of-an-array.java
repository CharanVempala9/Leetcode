class Solution {
    public int triangularSum(int[] nums) {
        int n=nums.length;
        int idx=n;
        int ans=0;
        for(int i=1; i<n; i++){
            if(idx==2){
                return (nums[0]+nums[1])%10;
            }
            for(int j=0; j<idx-1; j++){
                nums[j]=(nums[j]+nums[j+1])%10;
                //ans=(nums[j]+nums[j+1])%10;
            }
            idx--;
        }
        return nums[0];
    }
}