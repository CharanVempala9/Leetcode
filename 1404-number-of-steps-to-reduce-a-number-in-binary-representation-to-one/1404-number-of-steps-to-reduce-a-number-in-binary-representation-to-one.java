class Solution {
    public int numSteps(String s) {
        StringBuilder res=new StringBuilder(s);
        int cnt=0;
        while(res.length()>1){
            int n=res.length();
            if(res.charAt(n-1)=='0'){
                res.deleteCharAt(n-1);
            }
            else{
                res.setCharAt(n-1,'0');
                int idx=n-2;
                boolean fnd=false;
                while(idx>=0){
                    if(res.charAt(idx)=='0'){
                        res.setCharAt(idx,'1');
                        fnd=true;
                        break;
                    }
                    else
                    res.setCharAt(idx,'0');
                    idx--;
                }
                if(!fnd){
                    res.insert(0,'1');
                }
            }
            cnt++;
        }
        return cnt;
    }
}