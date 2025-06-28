class Solution {
    public int minSteps(String s, String t) {
        int[] sarr=new int[26];
        int[] tarr=new int[26];
        int n=s.length();
        for(int i=0; i<n; i++){
            sarr[s.charAt(i)-'a']++;
            tarr[t.charAt(i)-'a']++;
        }
        int cnt=0;
        for(int i=0; i<26; i++){
            if(sarr[i]>tarr[i])
            cnt+=sarr[i]-tarr[i];
        }
        return cnt;
    }
}