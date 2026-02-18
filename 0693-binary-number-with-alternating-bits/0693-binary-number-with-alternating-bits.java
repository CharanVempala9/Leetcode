class Solution {
    public boolean hasAlternatingBits(int n) {
        int idx=0;
        int prev=-1;
        while(n>0){
            int curr=n&1;
            if(idx>0 && curr==prev){
                return false;
            }
            prev=n&1;
            n=n>>1;
            idx++;
        }
        return true;
    }
}