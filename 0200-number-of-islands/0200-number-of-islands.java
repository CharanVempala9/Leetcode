class Pair{
    int f;
    int s;
    public Pair(int f,int s){
        this.f=f;
        this.s=s;
    }
}
class Solution {
    public void bfs(int r,int c, char[][] grid, int[][] vis){
        vis[r][c]=1;
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair>q=new LinkedList<Pair>();
        q.add(new Pair(r,c));
        while(!q.isEmpty()){
            int p1=q.peek().f;
            int p2=q.peek().s;
            q.remove();
            // Up
            if(p1-1>=0){
                int row=p1-1;
                int col=p2;
                if(grid[row][col]=='1' && vis[row][col]==0){
                    vis[row][col]=1;
                    q.add(new Pair(row,col));
                }
            }
            // Down
            if(p1+1<n){
                int row=p1+1;
                int col=p2;
                if(grid[row][col]=='1' && vis[row][col]==0){
                    vis[row][col]=1;
                    q.add(new Pair(row,col));
                }
            }
            // Left
            if(p2-1>=0){
                int row=p1;
                int col=p2-1;
                if(grid[row][col]=='1' && vis[row][col]==0){
                    vis[row][col]=1;
                    q.add(new Pair(row,col));
                }
            }
            // Right
            if(p2+1<m){
                int row=p1;
                int col=p2+1;
                if(grid[row][col]=='1' && vis[row][col]==0){
                    vis[row][col]=1;
                    q.add(new Pair(row,col));
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int cnt=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    cnt++;
                    bfs(i,j,grid,vis);
                }
            }
        }
        return cnt;
    }
}