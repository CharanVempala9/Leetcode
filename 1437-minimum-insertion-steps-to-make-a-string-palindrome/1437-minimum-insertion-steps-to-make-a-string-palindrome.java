class Solution {
    public int minInsertions(String s) {
        StringBuilder s2=new StringBuilder(s);
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=rec(n-1, n-1, s, s2.reverse().toString(), dp);
        return n-ans;
    }
    public int rec(int idx1, int idx2, String s1, String s2, int[][] dp){
        if(idx1<0 || idx2<0) {
            return 0;
        }
        if(dp[idx1][idx2] !=-1) return dp[idx1][idx2];
        int matched=0;
        int notmatched=0;
        if(s1.charAt(idx1) == s2.charAt(idx2)){
            matched= 1+ rec(idx1-1 , idx2-1 , s1, s2, dp);
        }
        else{
            notmatched=Math.max(rec(idx1, idx2-1 , s1, s2,dp), rec(idx1-1 , idx2 , s1, s2,dp));
        }
        dp[idx1][idx2] = Math.max(matched, notmatched);
        return dp[idx1][idx2];
    }
}