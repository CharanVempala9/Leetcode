class Solution {
    public int rec(int idx1, int idx2, String s1, String s2,int[][] dp){
        if(idx1<0 || idx2<0) return 0;
        if(dp[idx1][idx2] !=-1)  return dp[idx1][idx2];
        int matched=0;
        if(s1.charAt(idx1) == s2.charAt(idx2)){
            matched = 1+ rec(idx1-1, idx2-1, s1, s2 ,dp);
        }
        else{
            matched = Math.max(rec(idx1-1, idx2, s1, s2, dp) , rec(idx1, idx2-1, s1, s2,dp));
        }
        dp[idx1][idx2] = matched;
        return dp[idx1][idx2];
    }
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m][n];
        for(int i=0; i<m; i++) Arrays.fill(dp[i],-1);
        int ans= rec(m-1, n-1, word1, word2,dp);
        int deletionsOnS1 = m- ans;
        int deletionsOnS2 = n-ans;
        return deletionsOnS1+ deletionsOnS2;
    }
}