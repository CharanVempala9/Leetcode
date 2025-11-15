class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] res=new int[n][n];
        for(int[] q:queries){
            int sr=q[0];
            int sc=q[1];
            int er=q[2];
            int ec=q[3];
            for(int i=sr; i<=er; i++){
                res[i][sc]+=1;
                if(ec+1<n)res[i][ec+1]-=1;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=1; j<n; j++){
                res[i][j]+=res[i][j-1];
            }
        }
        return res;
    }
}