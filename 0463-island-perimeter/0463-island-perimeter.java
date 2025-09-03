class Solution {
    public int dfs(int r,int c,int[][] grid,int[][] vis){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]==0){
            return 1;
        }
        if(vis[r][c]==1) return 0;
        vis[r][c]=1;
        int ans=0;
        ans+=dfs(r-1,c,grid,vis);
        ans+=dfs(r+1,c,grid,vis);
        ans+=dfs(r,c-1,grid,vis);
        ans+=dfs(r,c+1,grid,vis);
        return ans;
    }
    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int ans=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    ans+=dfs(i,j,grid,vis);
                }
            }
        }
        return ans;
    }
}