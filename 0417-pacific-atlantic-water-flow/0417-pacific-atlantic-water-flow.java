class Solution {
    int[] rdir={-1,1,0,0};
    int[] cdir={0,0,-1,1};
    public void dfs(int r,int c,int[][] heights,int[][] vis){
        vis[r][c]=1;
        for(int i=0; i<4; i++){
            int nr=r+rdir[i];
            int nc=c+cdir[i];
            if(nr>=0 && nc>=0 && nr<heights.length && nc<heights[0].length && vis[nr][nc]==0 && heights[nr][nc]>=heights[r][c]){
                dfs(nr,nc,heights,vis);
            }
        }

    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>>ls=new ArrayList<>();
        int n=heights.length;
        int m=heights[0].length;
        int[][] atlan=new int[n][m];
        int[][] pac=new int[n][m];
        for(int i=0; i<m; i++){
            dfs(0,i,heights,pac);
        }
        for(int i=0; i<n; i++){
            dfs(i,0,heights,pac);
        }
        for(int i=0; i<m; i++){
            dfs(n-1,i,heights,atlan);
        }
        for(int i=0; i<n; i++){
            dfs(i,m-1,heights,atlan);
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(pac[i][j]==1 && atlan[i][j]==1){
                    ls.add(Arrays.asList(i,j));
                }
            }
        }
        return ls;
    }
}