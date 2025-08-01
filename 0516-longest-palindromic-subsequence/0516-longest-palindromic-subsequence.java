class Solution {
    public int lcs(int idx1, int idx2, String t1, String t2,int[][] dp){
        if(idx1<0 || idx2<0){
            return 0;
        }
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
        int matched=0;
        int unmatched=0;
        if(t1.charAt(idx1)==t2.charAt(idx2)){
            matched= 1+ lcs(idx1-1, idx2-1, t1, t2, dp);
        }
        else{
            unmatched=Math.max(lcs(idx1-1, idx2, t1, t2,dp), lcs(idx1, idx2-1, t1, t2,dp));  
        }
        dp[idx1][idx2] =  Math.max(matched, unmatched);
        return dp[idx1][idx2];
    }
    public int longestPalindromeSubseq(String s) {
        StringBuilder rev=new StringBuilder(s);
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        return lcs(n-1, n-1, s, rev.reverse().toString(),dp);
    }
}