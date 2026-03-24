class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] res=new int[n][m];
        int[] flatten=new int[n*m];
        int idx=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                flatten[idx]=grid[i][j];
                idx++;
            }
        }
        int tot=n*m;
        long[] pfx=new long[tot];
        long[] sfx=new long[tot];
        pfx[0]=1;
        sfx[tot-1]=1;
        for(int i=1; i<tot; i++){
            pfx[i]=(pfx[i-1]*flatten[i-1])%12345;
        }
        for(int i=tot-2; i>=0; i--){
            sfx[i]=(sfx[i+1]*flatten[i+1])%12345;
        }
        idx=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                long tmp=pfx[idx]*sfx[idx];
                res[i][j]=(int)(tmp%12345);
                idx++;
            }
        }
        return res;
    }
}




/*
long prod=1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                prod*=grid[i][j];
            }
        }
        System.out.println(prod);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                long div=prod/grid[i][j];
                res[i][j]=(int)(div%12345);
                //res[i][j]%=12345;
            }
        }
        return res;
*/