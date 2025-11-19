class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0; i<n; i++){
            if(nums[i]==original){
                original*=2;
            }
        }
        return original;
    }
}