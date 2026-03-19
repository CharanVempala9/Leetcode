class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] fx=new int[n][m];
        int[][] fy=new int[n][m];
        int cnt=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                fx[i][j]=(grid[i][j]=='X') ? 1:0;
                fy[i][j]=(grid[i][j]=='Y') ? 1:0;

                if(i-1>=0){
                    fx[i][j]+=fx[i-1][j];
                    fy[i][j]+=fy[i-1][j];
                }

                if(j-1>=0){
                    fx[i][j]+=fx[i][j-1];
                    fy[i][j]+=fy[i][j-1];
                }
                if(i-1>=0 && j-1>=0){
                    fx[i][j]-=fx[i-1][j-1];
                    fy[i][j]-=fy[i-1][j-1];
                }

                if(fx[i][j]==fy[i][j] && fx[i][j]>0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}