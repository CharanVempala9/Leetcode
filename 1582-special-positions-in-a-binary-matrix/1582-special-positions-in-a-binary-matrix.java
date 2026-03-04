class Solution {
    public boolean check(int[][] mat,int i,int j){
        //row check
        for(int k=0; k<mat[0].length; k++){
            if(mat[i][k]!=0 && k!=j){
                return false;
            }
        }
        for(int k=0; k<mat.length; k++){
            if(mat[k][j]!=0 && i!=k){
                return false;
            }
        }
        return true;
    }
    public int numSpecial(int[][] mat) {
        int n=mat.length;
        int cnt=0;
        int m=mat[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]==1){
                    if(check(mat,i,j))
                    cnt++;
                }
            }
        }
        return cnt;
    }
}