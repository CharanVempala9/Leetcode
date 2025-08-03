class Solution {
    public int rec(int i, int j, String s1, String s2,int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j] !=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            dp[i][j]= rec(i-1, j-1, s1, s2,dp);
        }
        else
        dp[i][j] = 1+ Math.min(rec(i-1, j, s1, s2,dp), Math.min(rec(i-1, j-1, s1, s2,dp), rec(i, j-1, s1, s2,dp)));
        return dp[i][j];
    }
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i],-1);
        }
        return rec(m-1, n-1, word1, word2,dp);
    }
} 