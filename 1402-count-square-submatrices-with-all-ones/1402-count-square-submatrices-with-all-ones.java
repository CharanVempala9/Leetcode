class Solution {
    public boolean isposs(int r, int c,int[][] matrix,int cnt){
        if (r + cnt > matrix.length || c + cnt > matrix[0].length) {
            return false;
        }
        for (int i = r; i < r + cnt; i++) {
            for (int j = c; j < c + cnt; j++) {
                if (matrix[i][j] == 0) {
                    return false; 
                }
            }
        }
        return true;
    }
    public int countSquares(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int upto=Math.min(n,m);
        int ans=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] ==1){
                    ans++;
                }
            }
        }
        for(int cnt=2; cnt<=upto; cnt++){
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(isposs(i,j,matrix,cnt)){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}