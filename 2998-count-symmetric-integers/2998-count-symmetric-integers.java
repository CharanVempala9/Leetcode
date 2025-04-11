class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans=0;
        for(int i=low; i<=high; i++){
            String temp=String.valueOf(i);
            if(temp.length()%2==0){
                int pcnt=0;
                int scnt=0;
                for(int j=0; j<temp.length()/2; j++){
                    pcnt+=temp.charAt(j)-'0';
                }
                for(int j=temp.length()/2; j<temp.length(); j++){
                    scnt+=temp.charAt(j)-'0';
                }
                if(pcnt==scnt)
                ans++;
            }
        }
        return ans;
    }
}