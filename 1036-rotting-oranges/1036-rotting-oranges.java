class Pair{
    int f;
    int s;
    int t;
    public Pair(int f,int s,int t){
        this.f=f;
        this.s=s;
        this.t=t;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        Queue<Pair>q=new LinkedList<>();
        int Fcnt=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                }
                else if(grid[i][j]==1){
                    Fcnt++;
                }
                else{
                    vis[i][j]=1;
                }
            }
        }
        int max=0;
        int op=0;
        int[] rdir={-1,1,0,0};
        int[] cdir={0,0,-1,1};
        while(!q.isEmpty()){
            int p1=q.peek().f;
            int p2=q.peek().s;
            int t=q.peek().t;
            max=Math.max(t,max);
            q.remove();
            for(int i=0; i<4; i++){
                int nr=p1+rdir[i];
                int nc=p2+cdir[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0 && grid[nr][nc]==1){
                    op++;
                    grid[nr][nc]=2;
                    vis[nr][nc]=1;
                    q.add(new Pair(nr,nc,t+1));
                }
            }
        }
        if(op==Fcnt) return max;
        return -1;
    }
}