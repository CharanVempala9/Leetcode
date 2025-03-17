class Solution {
    public boolean divideArray(int[] nums) {
        int[] newarr=new int[501];
        for(int i=0; i<nums.length; i++){
            newarr[nums[i]]++;
        }
        for(int num:newarr){
            if(num%2!=0)
            return false;
        }
        return true;

    }
}