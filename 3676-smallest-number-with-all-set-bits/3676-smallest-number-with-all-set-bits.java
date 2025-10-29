class Solution {
    public boolean checkbit(int n,int i){
        return ((n>>i)&1)==1;
    }
    public int smallestNumber(int n) {
        int idx=-1;
        for(int i=0; i<32; i++){
            if(checkbit(n,i)){
                idx=i;
            }
        }
        //System.out.println(idx);
        int res=0;
        int ans=0;
        for(int i=0; i<=idx; i++){
            ans+=Math.pow(2,res);
            res++;
        }
        return ans;
    }
}