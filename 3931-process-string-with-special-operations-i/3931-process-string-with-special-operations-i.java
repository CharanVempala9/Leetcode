class Solution {
    public String processStr(String s) {
        StringBuilder res=new StringBuilder();
        int idx=0;
        int n=s.length();
        int cnt=0;
        while(idx<n){
            char ch=s.charAt(idx);
            if(ch>='a' && ch<='z'){
                res.append(ch);
                cnt++;
            }
            else if(ch=='*'){
                if(res.length()>0){
                    res.deleteCharAt(cnt-1);
                    cnt--;
                }
            }
            else if(ch=='#'){
                StringBuilder rev=new StringBuilder(res);
                res.append(rev);
                cnt=cnt*2;
            }
            else{
                res=res.reverse();
            }
            idx++;
        }
        return res.toString();
    }
}