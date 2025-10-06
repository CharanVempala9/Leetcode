class Tuple{
    int r;
    int c;
    int t;
    public Tuple(int r,int c,int t){
        this.r=r;
        this.c=c;
        this.t=t;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int[] rdir={-1,1,0,0};
        int[] cdir={0,0,-1,1};
        int n=grid.length;
        int m=grid[0].length;
        int[][] dist=new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dist[i],(int)1e9);
        }
        int[][] vis=new int[n][m];
        PriorityQueue<Tuple>pq=new PriorityQueue<>((a,b)->a.t-b.t);
        pq.offer(new Tuple(0,0,grid[0][0]));
        vis[0][0]=1;
        dist[0][0]=0;
        while(!pq.isEmpty()){
            Tuple P=pq.poll();
            int r=P.r;
            int c=P.c;
            int t=P.t;
            if(r==n-1 && c==m-1) return dist[r][c];
            vis[r][c]=1;
            for(int i=0; i<4; i++){
                int nr=r+rdir[i];
                int nc=c+cdir[i];
                if(nr>=0 && nc>=0 && nr<n && nc<m && vis[nr][nc]==0){
                    int adjtime=Math.max(t,grid[nr][nc]);
                    if(adjtime<dist[nr][nc]){
                        dist[nr][nc]=adjtime;
                        pq.offer(new Tuple(nr,nc,adjtime));
                    }
                }
            }
        }
        return -1;
    }
}