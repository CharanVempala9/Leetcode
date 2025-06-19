class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int cnt=0;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int diff=0;
        for(int i=0; i<n; i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
            diff=max-min;
            if(diff>k){
                cnt++;
                min=nums[i];
                max=nums[i];
                diff=max-min;
            }
        }
        if(diff<=k){
            cnt+=1;
        }
        return cnt;
    }
}