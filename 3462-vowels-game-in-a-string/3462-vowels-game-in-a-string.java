class Solution {
    public boolean doesAliceWin(String s) {
        ArrayList<Integer>ls=new ArrayList<>();
        int cnt=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'){
                cnt++;
            }
            ls.add(cnt);
        }
        if(cnt==0) return false;
        int len=ls.size()-1;
        while(len>=0){
            int Vcnt=ls.get(len);
            if(Vcnt%2==1){
                cnt-=Vcnt;
                break;
            }
            len--;
        }
        if(cnt!=0 && cnt%2==0) return false;
        return true; 
    }
}