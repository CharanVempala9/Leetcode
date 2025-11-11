class Solution {
    public int rec(int idx,String[] strs,int m,int n,int[][][] dp){
        if(idx>=strs.length || m<0 || n<0){
            return 0;
        }
        if(m==0 && n==0){
            return 0;
        }
        if(dp[idx][m][n]!=0) return dp[idx][m][n];
        String s=strs[idx];
        int ocnt=0;
        int zcnt=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='1'){
                ocnt++;
            }
            else{
                zcnt++;
            }
        }
        int take=0;
        if(m-zcnt>=0 && n-ocnt>=0)
        take = 1+rec(idx+1,strs,m-zcnt,n-ocnt,dp);
        int nottake= rec(idx+1,strs,m,n,dp);
        dp[idx][m][n]= Math.max(take,nottake);
        return dp[idx][m][n];
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp=new int[strs.length][m+1][n+1];
        return rec(0,strs,m,n,dp);
    }
}