class Pair{
    int r;
    int c;
    int t;
    public Pair(int r,int c, int t){
        this.r=r;
        this.c=c;
        this.t=t;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] vis=new int[n][m];
        int[][] dist=new int[n][m];
        Queue<Pair>q=new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }
            }
        }
        int[] rdir={-1,1,0,0};
        int[] cdir={0,0,-1,1};
        while(!q.isEmpty()){
            int p1=q.peek().r;
            int p2=q.peek().c;
            int time=q.peek().t;
            q.remove();
            dist[p1][p2]=time;
            for(int i=0; i<4; i++){
                int nr=p1+rdir[i];
                int nc=p2+cdir[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0){
                    vis[nr][nc]=1;
                    q.add(new Pair(nr,nc,time+1));
                }
            }
        }
        return dist;
    }
}