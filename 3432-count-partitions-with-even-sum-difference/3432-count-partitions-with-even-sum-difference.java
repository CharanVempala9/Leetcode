class Solution {
    public int countPartitions(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0; i<n; i++){
            sum+=nums[i];
        }
        int cnt=0;
        int ssum=0;
        for(int i=0; i<n-1; i++){
            sum-=nums[i];
            ssum+=nums[i];
            if((sum-ssum)%2==0)cnt++;
        }
        return cnt;
    }
}