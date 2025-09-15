class Pair{
    int r;
    int c;
    int wt;
    public Pair(int r,int c,int wt){
        this.r=r;
        this.c=c;
        this.wt=wt;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int V=grid.length;
        if(grid[0][0]!=0 || grid[V-1][V-1]!=0)return -1;
        int[][] dist=new int[V][V];
        int[] rdir = {-1,-1,-1,0,0,1,1,1};
        int[] cdir = {-1,0,1,-1,1,-1,0,1};
        for(int[] d:dist){
            Arrays.fill(d,(int)1e9);
        }
        Queue<Pair>q=new LinkedList<>();
        q.offer(new Pair(0,0,1));
        dist[0][0]=1;
        while(!q.isEmpty()){
            Pair p=q.poll();
            int r=p.r;
            int c=p.c;
            int adjWt=p.wt;
            for(int i=0; i<8; i++){
                int nr=r+rdir[i];
                int nc=c+cdir[i];
                if(nr>=0 &&  nc>=0 && nr<V && nc<V && grid[nr][nc]==0){
                    if(adjWt+1<dist[nr][nc]){
                        dist[nr][nc]=adjWt+1;
                        q.offer(new Pair(nr,nc,adjWt+1));
                    }
                }
            }
        }
        if(dist[V-1][V-1]==(int)1e9) return -1;
        return dist[V-1][V-1];

    }
}