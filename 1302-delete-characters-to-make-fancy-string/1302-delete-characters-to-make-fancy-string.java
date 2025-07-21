class Solution {
    public String makeFancyString(String s) {
        StringBuilder res=new StringBuilder();
        int n=s.length();
        res.append(s.charAt(0));
        int cnt=0;
        for(int i=1; i<n; i++){
            if(s.charAt(i-1)==s.charAt(i)){
                cnt++;
                if(cnt>=2){
                    continue;
                }
                res.append(s.charAt(i));
            }
            else{
                cnt=0;
                res.append(s.charAt(i));
            }
        }
        return res.toString();

    }
}