class Solution {
    public int repeatedStringMatch(String a, String b) {
        if(a.length()==0 || b.length()==0)
        return 0;
        StringBuilder res=new StringBuilder(a);
        int cnt=1;
        while(res.length()<b.length()){
            res.append(a);
            cnt++;
        }
        if(res.toString().contains(b)){
            return cnt;
        }
        res.append(a);
        cnt++;
        if(res.toString().contains(b)){
            return cnt;
        }
        return -1;
    }
}