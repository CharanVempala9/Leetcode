class Solution {
    static int m=(int)1e9+7;
    public long findpower(long a,long b){
        if(b==0){
            return 1;
        }
        long half=findpower(a,b/2);
        long res=(half*half)%m;
        if(b%2==1)
        res=(res*a)%m;
        return res;
    }
    public int countGoodNumbers(long n) {
        long even=findpower(5,(n+1)/2);
        long odd=findpower(4,n/2);
        return (int)((even*odd)%m);
    }
}