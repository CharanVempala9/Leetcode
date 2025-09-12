class Solution {
    public boolean doesAliceWin(String s) {
        int maxOdd=0;
        int cnt=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'){
                cnt++;
            }
            if(cnt%2==1)
            maxOdd=Math.max(cnt,maxOdd);
        }
        if(cnt==0) return false;
        // int len=ls.size()-1;
        // while(len>=0){
        //     int Vcnt=ls.get(len);
        //     if(Vcnt%2==1){
        //         cnt-=Vcnt;
        //         break;
        //     }
        //     len--;
        // }
        cnt-=maxOdd;
        if(cnt!=0 && cnt%2==0) return false;
        return true; 
    }
}