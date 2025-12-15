class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans=0;
        int l=0;
        int n=prices.length;
        for(int r=1; r<n; r++){
            if((prices[r-1]-prices[r])==1){
                continue;
            }
            else{
                int res=r-l;
                ans+=(long)res*(res+1)/2;
                l=r;
            }
        }
        int len = n - l;
        ans += (long) len * (len + 1) / 2;
        return ans;
    }
}


/*  n*(n+1)/2 -> subarrays... 4*(5)/2--> 10
                              3*(4)/2 -> 6


*/