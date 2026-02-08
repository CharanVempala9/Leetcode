class Solution {
    public int dominantIndices(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int i=0; i<n-1; i++){
            int t=nums[i];
            int sum=0;
            int cnt=0;
            for(int j=i+1; j<n; j++){
                sum+=nums[j];
                cnt++;
            }
            if(t>(sum/cnt)){
                ans++;
            }
        }
        return ans;
    }
}