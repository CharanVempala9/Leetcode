class Solution {
    public boolean rec(int i, int j, String s, String p,Boolean[][] dp){
        if(i<0 && j<0) return true;
        if(j<0) return false;
        if (i < 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }
        if(dp[i][j] !=null)  return dp[i][j];
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            dp[i][j] = rec(i-1, j-1, s, p,dp);
        }
        else if(p.charAt(j) == '*'){
            dp[i][j] = rec(i-1, j, s, p,dp) || rec(i, j-1, s, p,dp);
        }
        else{
            dp[i][j]=false;
        }
        return dp[i][j];
    }
    public boolean isMatch(String s, String p) {
        int i=s.length();
        int j=p.length();
        Boolean[][] dp=new Boolean[i][j];
        return rec(i-1, j-1, s, p,dp);
    }
}