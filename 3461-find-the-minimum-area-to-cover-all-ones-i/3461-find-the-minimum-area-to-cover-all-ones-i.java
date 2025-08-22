class Solution {
    public int minimumArea(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int rmin=Integer.MAX_VALUE;
        int rmax=Integer.MIN_VALUE;
        int cmin=Integer.MAX_VALUE;
        int cmax=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    rmin=Math.min(i,rmin);
                    cmin=Math.min(j,cmin);
                    rmax=Math.max(i,rmax);
                    cmax=Math.max(j,cmax);
                }
            }
        }
        int l=rmax-rmin+1;
        int b=cmax-cmin+1;
        return l*b;
    }
}