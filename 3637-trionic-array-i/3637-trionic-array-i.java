class Solution {
    public boolean isTrionic(int[] nums) {
        boolean one=false;
        boolean two=false;
        boolean three=false;
        int n=nums.length;
        if(n>1 && nums[0]>nums[1])return false;
        int i=0;
        for(i=1; i<n; i++){
            if(!one && nums[i-1]<nums[i]){
                one=true;
            }
            if(one && nums[i-1]>nums[i]){
                two=true;
            }
            if(two && nums[i-1]<nums[i]){
                three=true;
                break;
            }
            else if(nums[i-1]==nums[i]){
                return false;
            }
        }
        while(i+1<n){
            if(nums[i]>nums[i+1])return false;
            else if(nums[i]==nums[i+1]) return false;
            i++;
        }
        return ((one && two) && three);

    }
}