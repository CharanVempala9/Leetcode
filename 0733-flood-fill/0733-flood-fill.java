class Solution {
    public void dfs(int r, int c,int oldColor, int  color, int[][] image,int[][] vis){
        if(r<0 || r>=image.length || c<0 || c>=image[0].length || image[r][c]!=oldColor || vis[r][c]==1){
            return;
        }
        vis[r][c]=1;
        image[r][c]=color;
        dfs(r-1,c,oldColor,color,image,vis);
        dfs(r+1,c,oldColor,color,image,vis);
        dfs(r,c-1,oldColor,color,image,vis);
        dfs(r,c+1,oldColor,color,image,vis);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int[][] vis=new int[n][m];
        int oldColor=image[sr][sc];
        dfs(sr,sc,oldColor,color,image,vis);
        return image;
    }
}