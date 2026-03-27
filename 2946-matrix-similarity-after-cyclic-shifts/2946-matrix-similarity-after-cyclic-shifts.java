class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n=mat.length;
        int m=mat[0].length;
        k = k % m;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int val=mat[i][j];
                int nxtVal=-1;
                if(i%2==0){
                    nxtVal=mat[i][(j-k+m)%m];
                }
                else{
                    nxtVal=mat[i][(j+k)%m];
                }
                if(val!=nxtVal){
                    return false;
                }
            }
        }
        return true;
    }
}