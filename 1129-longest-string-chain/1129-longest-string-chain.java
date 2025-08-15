class Solution {
    public boolean isposs(String s1, String s2) {
        if (s1.length() != s2.length() + 1) return false;
        int f = 0, s = 0;
        while (f < s1.length()) {
            if (s < s2.length() && s1.charAt(f) == s2.charAt(s)) {
                f++;
                s++;
            } else {
                f++;
            }
        }
        return s == s2.length();
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b)-> Integer.compare(a.length() , b.length()));
        int n=words.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,1);
        int max=0;
        for(int i=0; i<n; i++){
            for(int prev=0; prev<i; prev++){
                if(isposs(words[i],words[prev]) && dp[prev]+1 > dp[i] ){
                    dp[i] = dp[prev] +1;
                }
            }
            if(dp[i] > max){
                max= dp[i];
            }
        }
        return max;
    }
}