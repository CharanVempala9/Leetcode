class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] res=new int[n][n];
        for(int[] q:queries){
            int sr=q[0];
            int sc=q[1];
            int er=q[2];
            int ec=q[3];
            for(int i=sr; i<=er; i++){
                for(int j=sc; j<=ec; j++){
                    res[i][j]+=1;
                }
            }
        }
        return res;
    }
}