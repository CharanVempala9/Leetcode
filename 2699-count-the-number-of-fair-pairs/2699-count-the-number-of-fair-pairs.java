class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long lupper=calculate(nums,upper);
        long llower=calculate(nums,lower-1);
        return lupper-llower;
    }
    public static long calculate(int[] nums,int val){
        int left=0;
        int right=nums.length-1;
        long ans=0;
        while(left<right){
            long sum=nums[left]+nums[right];
            if(sum>val)
            {
                right--;
            }
            else{
                ans+=right-left;
                left++;
            }
        }
        return ans;
    }
}