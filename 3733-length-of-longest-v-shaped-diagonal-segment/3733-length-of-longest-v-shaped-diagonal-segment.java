class Solution {
    int dirs[][]={{1,1},{1,-1},{-1,-1},{-1,1}};
    int n;
    int m;
    int dp[][][][];

    public int lenOfVDiagonal(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        dp=new int[n][m][4][2];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                for(int k=0; k<4; k++) {
                    Arrays.fill(dp[i][j][k],-1);
                }
            }
        }
        int ans=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]==1) {
                    for(int d=0; d<4; d++) {
                        ans=Math.max(ans,solve(i,j,d,1,2,grid)+1);
                    }
                }
            }
        }
        return ans;
    }
    
    int solve(int i,int j,int direction,int turn,int search,int grid[][]) {
        int nx=i+dirs[direction][0];
        int ny=j+dirs[direction][1];

        if(nx<0 || nx>=n || ny<0 || ny>=m || grid[nx][ny]!=search) return 0;

        if(dp[i][j][direction][turn]!=-1) return dp[i][j][direction][turn];
        int ans=solve(nx,ny,direction,turn,2-search,grid);
        if(turn>0) {
            ans=Math.max(ans,solve(nx,ny,(direction+1)%4,turn-1,2-search,grid));
        }
        return dp[i][j][direction][turn]=ans+1;
    }
}