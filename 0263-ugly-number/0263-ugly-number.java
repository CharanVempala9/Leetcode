class Solution {
    public boolean isUgly(int n) {
        if(n<=0)return false;
        int[] pms={2,3,5};
        for(int p:pms){
            while(n%p==0){
                n/=p;
            }
        }
        return n==1;
    }
}