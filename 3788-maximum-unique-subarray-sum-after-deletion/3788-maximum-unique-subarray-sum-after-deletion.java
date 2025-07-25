class Solution {
    public int maxSum(int[] nums) {
        int n=nums.length;
        int max=nums[0];
        int sum=0;
        HashSet<Integer>hs=new HashSet<>();
        if(nums[0]>0) hs.add(nums[0]);
        for(int i=1; i<n; i++){
            max=Math.max(max,nums[i]);
            if(nums[i]>0)
            hs.add(nums[i]);
        }
        for(int val:hs) sum+=val;
        if(max<0) return max;
        return sum;
    }
}