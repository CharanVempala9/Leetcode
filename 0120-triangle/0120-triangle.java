class Solution {
    public int isposs(int r,int c,List<List<Integer>> triangle,int[][] dp){
        if(r<0 || c<0 || c>=triangle.get(r).size()){
            return (int)1e9;
        }
        if(r==0 && c==0){
            return triangle.get(0).get(0);
        }
        if(dp[r][c]!=-1)return dp[r][c];
        int up=isposs(r-1,c,triangle,dp);
        int diag=isposs(r-1,c-1,triangle,dp);
        dp[r][c]= Math.min(up,diag)+triangle.get(r).get(c);
        return dp[r][c];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int m=triangle.get(triangle.size()-1).size();
        int min=Integer.MAX_VALUE;
        int[][] dp=new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0; i<m; i++){
            int val=triangle.get(n-1).get(i);
            min=Math.min(isposs(n-1,i,triangle,dp),min);
        }
        return min;
    }
}