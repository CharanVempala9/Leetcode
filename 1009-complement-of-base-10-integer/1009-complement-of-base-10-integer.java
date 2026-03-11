class Solution {
    public int bitwiseComplement(int n) {
        int res=n;
        int ans=0;
        int idx=0;
        if(n==0) return 1;
        while(res>0){
            int st=res&1;
            System.out.println(res&1);
            if(st==1)
            ans=ans|(0<<idx);
            else
            ans=ans|(1<<idx);
            res=res>>1;
            idx++;
        }
        return ans;
    }
}