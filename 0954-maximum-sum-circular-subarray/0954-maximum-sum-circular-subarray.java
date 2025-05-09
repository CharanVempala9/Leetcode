class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int sum=0;
        int minsum=0;
        int neg=nums[0];
        int total=0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
           sum+=nums[i];
           minsum+=nums[i];
           total+=nums[i];
           if(sum<0){
            sum=0;
           }
           if(minsum>0){
            minsum=0;
           }
           min=Math.min(minsum,min);
           max=Math.max(sum,max);
           neg=Math.max(neg,nums[i]);
        }
        if(max>1)
        return Math.max(max,total-min);
        return neg;
    }
}