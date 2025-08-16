class Solution {
    public int findNumberOfLIS(int[] arr) {
        int n=arr.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,1);
        int[] cnt = new int[n+1];
        Arrays.fill(cnt,1);
        int max=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[j]<arr[i] && dp[j] +1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    cnt[i] = cnt[j];
                }
                else if(arr[j]<arr[i] && dp[j] +1 == dp[i]){
                    cnt[i]  = cnt[i] + cnt[j];
                }
            }
            if(dp[i] > max){
                max= dp[i];
            }
        }
        int ans=0;
        for(int i=0; i<n; i++){
            if(dp[i] ==  max){
                ans  = ans + cnt[i];
            }
        }
        return ans;
    }
}