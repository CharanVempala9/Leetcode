class Solution {
    public int[] applyOperations(int[] nums) {
        int n=nums.length;
        for(int i=1; i<nums.length; i++){
            if(nums[i-1]!=nums[i]){
                continue;
            }
            else{
                nums[i-1]=nums[i-1]*2;
                nums[i]=0;
            }
        }
        int p1=0;
        int i=0;
        while(i<n){
            if(nums[i]>0){
                nums[p1]=nums[i];
                p1++;
            }
            i++;
        }
        while(p1<n){
            nums[p1]=0;
            p1++;
        }
        return nums;

    }
}