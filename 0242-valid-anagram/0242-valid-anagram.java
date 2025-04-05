class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sarr=new int[27];
        int[] tarr=new int[27];
        if(s.length()!=t.length())
        return false;
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            char c=t.charAt(i);
            sarr[ch-'a']++;
            tarr[c-'a']++;
        }
        for(int i=0; i<27; i++){
            if(sarr[i]!=tarr[i])
            return false;
        }
        return true;
    }
}