class Solution {
    public boolean isposs(String s1, String s2, String s3,int idx1, int idx2, int idx3,Boolean[][] dp){
        if(idx3==s3.length()){
            return (s1.length()==idx1 && s2.length()==idx2);
        }
        if(dp[idx1][idx2]!=null) return dp[idx1][idx2];
        boolean ans=false;
        if(idx1<s1.length() && s1.charAt(idx1)==s3.charAt(idx3) && idx2<s2.length() && s2.charAt(idx2)==s3.charAt(idx3)){
            ans = isposs(s1,s2,s3,idx1+1,idx2,idx3+1,dp) || isposs(s1,s2,s3,idx1,idx2+1,idx3+1,dp);
        }
        else if(idx1<s1.length() && s1.charAt(idx1)==s3.charAt(idx3)){
            ans= ans || isposs(s1,s2,s3,idx1+1,idx2,idx3+1,dp);
        }
        else if(idx2<s2.length() &&  s2.charAt(idx2)==s3.charAt(idx3)){
            ans = ans || isposs(s1,s2,s3,idx1,idx2+1,idx3+1,dp);
        }
        dp[idx1][idx2] =  ans;
        return dp[idx1][idx2];
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1=s1.length();
        int n2=s2.length();
        int n3=s3.length();
        if(n1+n2!=n3) return false;
        Boolean[][] dp=new Boolean[n1+1][n2+1];
        return isposs(s1,s2,s3,0,0,0,dp);
    }
}