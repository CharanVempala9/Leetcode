class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int diff=0;
        int n=nums.length;
        for(int i=0; i<n; i++){
            int next=(i+1)%n;
            int temp=Math.abs(nums[i]-nums[next]);
            diff=Math.max(temp,diff);
        }
        return diff;
    }
}