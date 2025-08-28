class Solution {
    List<List<Integer>>Low=new ArrayList<>();
    List<List<Integer>>Upp=new ArrayList<>();
    public void Lowstore(int r,int c,int[][] grid,int[][] vis,List<Integer>ls){
        if(r>=grid.length || c>=grid[0].length){
            Collections.sort(ls,Collections.reverseOrder());
            Low.add(ls);
            return;
        }
        vis[r][c]=1;
        ls.add(grid[r][c]);
        Lowstore(r+1,c+1,grid,vis,ls);
    }
    public void Upstore(int r,int c,int[][] grid,int[][] vis,List<Integer>ls){
        if(r>=grid.length || c>=grid[0].length){
            Collections.sort(ls);
            Upp.add(ls);
            return;
        }
        vis[r][c]=1;
        ls.add(grid[r][c]);
        Upstore(r+1,c+1,grid,vis,ls);
    }
    public void addLow(int r,int c,int[][] grid,int[][] res,int lidx){
        if(r>=grid.length || c>=grid[0].length || res[r][c]!=-(int)Math.pow(10,6)){
            return;
        }
        res[r][c]=Low.get(lidx).remove(0);
        addLow(r+1,c+1,grid,res,lidx);
    }
    public void addUpp(int r,int c,int[][] grid,int[][] res,int uidx){
        if(r>=grid.length || c>=grid[0].length || res[r][c]!=-(int)Math.pow(10,6)){
            return;
        }
        res[r][c]=Upp.get(uidx).remove(0);
        addUpp(r+1,c+1,grid,res,uidx);
    }
    public int[][] sortMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(j<=i && vis[i][j]==0){
                    Lowstore(i,j,grid,vis,new ArrayList<>());
                }
                else if(j>i && vis[i][j]==0){
                    Upstore(i,j,grid,vis,new ArrayList<>());
                }
            }
        }
        int[][] res=new int[n][m];
        int bound=-(int)Math.pow(10,6);
        for(int i=0; i<n; i++){
            Arrays.fill(res[i],bound);
        }
        int lidx=0;
        int uidx=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(j<=i && res[i][j]==bound){
                    addLow(i,j,grid,res,lidx);
                    lidx++;
                }
                else if(j>i && res[i][j]==bound){
                    addUpp(i,j,grid,res,uidx);
                    uidx++;
                }
            }
        }
        return res;
    }
}