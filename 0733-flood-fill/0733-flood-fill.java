class Pair{
    int f;
    int s;
    public Pair(int f,int s){
        this.f=f;
        this.s=s;
    }
}
class Solution {
    int[] rdir={-1,1,0,0};
    int[] cdir={0,0,-1,1};
    public void bfs(int r, int c,int oldColor, int  color, int[][] image,int[][] vis){
        Queue<Pair>q=new LinkedList<Pair>();
        int n=image.length;
        int m=image[0].length;
        vis[r][c]=1;
        image[r][c]=color;
        q.add(new Pair(r,c));
        while(!q.isEmpty()){
            int p1=q.peek().f;
            int p2=q.peek().s;
            q.remove();
            for(int i=0; i<4; i++){
                int nr=p1+rdir[i];
                int nc=p2+cdir[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && image[nr][nc]==oldColor && vis[nr][nc]==0){
                    image[nr][nc]=color;
                    vis[nr][nc]=1;
                    q.add(new Pair(nr,nc));
                }
            }
        }
        
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int[][] vis=new int[n][m];
        int oldColor=image[sr][sc];
        bfs(sr,sc,oldColor,color,image,vis);
        return image;
    }
}