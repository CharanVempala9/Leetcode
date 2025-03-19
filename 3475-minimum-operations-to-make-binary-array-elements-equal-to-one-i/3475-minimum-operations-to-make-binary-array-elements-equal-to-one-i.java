class Solution {
    public int minOperations(int[] nums) {
        int l=0;
        int n=nums.length;
        int k=3;
        int ans=0;
        int sum=0;
        for(int r = 0; r < n; r++) {
        sum += nums[r];
        if (r - l + 1 == k) {
            if (nums[l] == 0 && sum < 3) {
                for (int idx = l; idx <= r; idx++) {
                if (nums[idx] == 0) nums[idx] = 1;
                else nums[idx] = 0;
                }
                ans++;
                sum = 0;
                for (int idx = l; idx <= r; idx++) sum += nums[idx];
            }
            sum -= nums[l];
            l++;
        }
        }
        for(int i=0;i<n; i++){
            if(nums[i]!=1)
            return -1;

        }
        return ans;

    }
}