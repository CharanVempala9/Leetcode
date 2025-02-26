class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int forwardsum=0;
        int revsum=0;
        int max=0;
        int min=Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            forwardsum+=nums[i];
            revsum+=nums[i];
            if(forwardsum<0){
                forwardsum=0;
            }
            if(revsum>0){
                revsum=0;
            }
            max=Math.max(max,forwardsum);
            min=Math.min(min,revsum);
        }
        return Math.max(max, Math.abs(min));
    }
}