class Solution {
    public void dfs(int r, int c, char[][] board,int[][] vis){
        if(r<0 || r>=board.length || c<0 || c>=board[0].length || vis[r][c]==1 || board[r][c]=='X'){
            return;
        }
        vis[r][c]=1;
        dfs(r-1,c,board,vis);
        dfs(r+1,c,board,vis);
        dfs(r,c-1,board,vis);
        dfs(r,c+1,board,vis);
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[][] vis=new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(board[i][j]=='O'){
                        dfs(i,j,board,vis);
                    }
                }
                else{
                    continue;
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]=='O' && vis[i][j]==0)
                board[i][j]='X';
            }
        }
    }
}