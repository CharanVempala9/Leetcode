class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String>hs=new HashSet<>();
        int n=s.length();
        int l=0;
        StringBuilder res=new StringBuilder();
        for(int r=0; r<n; r++){
            res.append(s.charAt(r));
            if(r-l+1==k){
                hs.add(res.toString());
                res.deleteCharAt(0);
                l++;
            }
        }
        return hs.size()==(1<<k);
    }
}