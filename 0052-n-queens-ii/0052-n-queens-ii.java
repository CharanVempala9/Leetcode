class Solution {
    public int count(boolean[][] board,int r){
        if(r==board.length){
            return 1;
        }
        int res=0;
        for(int c=0; c<board.length; c++){
            if(isSafe(board,r,c)){
                board[r][c]=true;
                res+=count(board,r+1);
                board[r][c]=false;
            }
        }
        return res;
    }
    public boolean isSafe(boolean[][] board,int r,int c){
        //vertical
        for(int i=0; i<r; i++){
            if(board[i][c]){
                return false;
            }
        }
        //diagonal left
        int maxLeft=Math.min(r,c);
        for(int i=1; i<=maxLeft; i++){
            if(board[r-i][c-i])
            return false;
        }
        //diagonal right
        int maxRight=Math.min(r,board.length-1-c);
        for(int i=1; i<=maxRight; i++){
            if(board[r-i][c+i])
            return false;
        }
        //if not exist
        return true;
    }
    public int totalNQueens(int n) {
        boolean[][] board=new boolean[n][n];
        int ans=count(board,0);
        return ans;
    }
}