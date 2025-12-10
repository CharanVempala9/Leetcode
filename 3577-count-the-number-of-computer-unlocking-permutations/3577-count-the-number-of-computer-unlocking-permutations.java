class Solution {
    static int mod=1000000007;
    public long fact(int n){
        long res=1;
        for(int i=2; i<=n; i++){
            res=(res*i)%mod;
        }
        return res;
    }
    public int countPermutations(int[] c) {
        int t=c[0];
        int n=c.length;
        for(int i=1; i<n; i++){
            if(c[i]<=t)return 0;
        }
        return (int)fact(n-1);
    }
}