class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long tot=0;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                tot+=grid[i][j];
            }
        }
        if(tot%2==1)return false;
        long req=tot/2;
        long horiz=0;
        for(int i=0; i<n; i++){
            long tmp=0;
            for(int j=0; j<m; j++){
                tmp+=grid[i][j];
            }
            horiz+=tmp;
            if(horiz==req){
                return true;
            }
            else if(horiz>req){
                break;
            }
        }
        long vert=0;
        for(int j=0; j<m; j++){
            long tmp=0;
            for(int i=0; i<n; i++){
                tmp+=grid[i][j];
            }
            vert+=tmp;
            if(vert==req){
                return true;
            }
            else if(vert>req){
                break;
            }
        }
        return false;
    }
}