class Solution {
    public long minCuttingCost(int n, int m, int k) {
        long ans=0;
        if(n<=k && m<=k)
        return 0;
        long temp=0;
        if(n>k){
            temp=n-k;
        }
        else{
            temp=m-k;
        }
        ans=temp*k;
        return ans;
    }
}