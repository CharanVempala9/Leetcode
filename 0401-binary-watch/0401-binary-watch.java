class Solution {
    public int setbits(int n){
        int cnt=0;
        while(n>0){
            if((n&1)==1){
                cnt++;
            }
            n=n>>1;
        }
        return cnt;
    }
    public List<String> readBinaryWatch(int turnedOn) {
        List<String>ls=new ArrayList<>();
        for(int i=0; i<12; i++){
            for(int j=0; j<60; j++){
                if(setbits(i)+setbits(j)==turnedOn){
                    if(j<10){
                        ls.add(i+":"+"0"+j);
                    }
                    else{
                        ls.add(i+":"+j);
                    }
                }
            }
        }
        return ls;
    }
}