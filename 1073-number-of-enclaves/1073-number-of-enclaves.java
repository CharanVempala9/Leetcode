class Solution {
    public void dfs(int r,int c,int[][] grid, int[][] vis){
        if(r>=grid.length || r<0 || c<0 || c>=grid[0].length || vis[r][c]==1 || grid[r][c]==0){
            return;
        }
        vis[r][c]=1;
        dfs(r-1,c,grid,vis);
        dfs(r+1,c,grid,vis);
        dfs(r,c-1,grid,vis);
        dfs(r,c+1,grid,vis);
    }
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(grid[i][j]==1 && vis[i][j]==0){
                        dfs(i,j,grid,vis);
                    }
                }
            }
        }
        int cnt=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1 && vis[i][j]==0)
                cnt++;
            }
        }
        return cnt;
    }
}