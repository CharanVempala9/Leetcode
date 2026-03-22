class Solution {
    public boolean check(int[][] mat,int[][] t){
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]!=t[i][j]) return false;
                //System.out.print(mat[i][j]+" ");
            }
            //System.out.println();
        }
        return true;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        int n=mat.length;
        int m=mat[0].length;
        int max=3;
        if(check(mat,target)) return true;
        while(max-->0){
            int[][] newM=new int[n][m];
            int a=0;
            for(int j=0; j<m; j++){
                int b=0;
                for(int i=n-1; i>=0; i--){
                    newM[a][b]=mat[i][j];
                    b++;
                }
                a++;
            }
            if(check(newM,target)) return true;
            mat=newM;
        }
        return false;
    }
}


/*      1 0     0 1     1 0   0 1   1 0
        0 1     1 0     0 1   1 0   0 1


*/