class Solution {
    public int numberOfBeams(String[] bank) {
        int bfr=-1;
        int ans=0;
        int n=bank.length;
        for(int i=0; i<n; i++){
            int cnt=0;
            for(int j=0; j<bank[i].length(); j++){
                if(bank[i].charAt(j)=='1'){
                    cnt++;
                }
            }
            if(bfr==-1){
                bfr=cnt;
            }
            else{
                ans+=cnt*bfr;
                //System.out.print("cnt"+cnt+" "+"bfr"+bfr);
                if(cnt!=0){
                    bfr=cnt;
                }
            }
        }
        return ans;
    }
}