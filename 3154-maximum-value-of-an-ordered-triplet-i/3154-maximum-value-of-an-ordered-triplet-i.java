class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        long max=0;
        long diff=0;
        long triplet=0;
        for(int i=0; i<n; i++){
            triplet=Math.max(triplet,nums[i]*diff);
            max=Math.max(max,nums[i]);
            diff=Math.max(diff,max-nums[i]);
        }
        return triplet;
    }
}