class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int i=0;
        int max=0;
        while(i<n/2){
            int sum = nums[i]+nums[n-i-1];
            max=Math.max(max,sum);
            i++;
        }
        return max;
    }
}