class Solution {
    public int reverseBits(int n) {
        int ans=0;
        for(int i=0; i<32; i++){
            if(i>0)ans=ans<<1;
            ans = (ans | ((n>>i)&1));
        }
        return ans;
    }

}