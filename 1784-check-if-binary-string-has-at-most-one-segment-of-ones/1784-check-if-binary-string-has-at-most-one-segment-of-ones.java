class Solution {
    public boolean checkOnesSegment(String s) {
        int n=s.length();
        if(n==1) return true;
        int ones=0;
        int cnt=-1;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='1'){
                ones++;
                if(cnt>0){
                    return false;
                }
            }
            else{
                cnt=1;
            }
        }
        return true;
    }
}