class Solution {
    public int maxOperations(String s) {
        int n=s.length();
        int[] pfx=new int[n];
        pfx[0]=s.charAt(0)=='1' ? 1: 0;
        //System.out.print(pfx[0]+" ");
        for(int i=1; i<n; i++){
            pfx[i]=pfx[i-1]+(s.charAt(i)=='1'? 1:0);
            //System.out.print(pfx[i]+" ");
        }
        int cnt=0;
        for(int i=n-2; i>=0; i--){
            if(s.charAt(i+1)=='0' && s.charAt(i)=='1'){
                int idx=i;
                //System.out.println(idx);
                cnt+=pfx[i];
            }
        }
        return cnt;
    }
}