class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int n=grid.length;
        int m=grid[0].length;
        for(int j=y; j<y+k && j<m; j++){
            int[] tmp=new int[k];
            int idx=0;
            for(int i=x; i<x+k && i<n; i++){
                tmp[idx]=grid[i][j];
                idx++;
            }
            for(int i=x; i<x+k && i<n; i++){
                grid[i][j]=tmp[--idx];
            }
            //System.out.println();
        }
        return grid;
    }
}


//   0   3   4          0+k<len 