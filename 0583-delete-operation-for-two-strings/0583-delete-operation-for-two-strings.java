class Solution {
    // public int rec(int idx1, int idx2, String s1, String s2,int[][] dp){
    //     if(idx1<0 || idx2<0) return 0;
    //     if(dp[idx1][idx2] !=-1)  return dp[idx1][idx2];
    //     int matched=0;
    //     if(s1.charAt(idx1) == s2.charAt(idx2)){
    //         matched = 1+ rec(idx1-1, idx2-1, s1, s2 ,dp);
    //     }
    //     else{
    //         matched = Math.max(rec(idx1-1, idx2, s1, s2, dp) , rec(idx1, idx2-1, s1, s2,dp));
    //     }
    //     dp[idx1][idx2] = matched;
    //     return dp[idx1][idx2];
    // }
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m+1][n+1];
        //base cases
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        int len=dp[m][n];
        int deltetionsOns1 = m-len;
        int deltetionsOns2 = n-len;
        return deltetionsOns1 + deltetionsOns2; 
    }
}