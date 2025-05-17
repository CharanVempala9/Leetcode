class Solution {
    public boolean isAcronym(List<String> words, String s) {
        int p1=0;
        int n=words.size();
        int p2=s.length();
        if(n<p2 || p2<n)
        return false;
        while(p1<p2){
            if(s.charAt(p1)!=words.get(p1).charAt(0))
            return false;
            p1++;
        }
        return true;
    }
}