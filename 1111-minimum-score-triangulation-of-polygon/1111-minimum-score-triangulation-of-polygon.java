class Solution {
    public int gen(int i,int j,int[] val,int[][] dp){
        if(j-i+1<3){
            return 0;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        int res=Integer.MAX_VALUE;
        for(int k=i+1; k<j; k++){
            int take = val[i]*val[j]*val[k] + gen(i,k,val,dp) + gen(k,j,val,dp) ;
            res=Math.min(res,take);
        }
        dp[i][j]= res;
        return dp[i][j];
    }
    public int minScoreTriangulation(int[] values) {
        int n=values.length;
        int[][] dp=new int[n+1][n+1];
        for(int i=0; i<n+1; i++){
            Arrays.fill(dp[i],-1);
        }
        return gen(0,n-1,values,dp);
    }
}