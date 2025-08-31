class Solution {
    public boolean solve(char[][] board){
        int row=-1;
        int col=-1;
        boolean found=true;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[i][j]=='.'){
                    row=i;
                    col=j;
                    found=false;
                    break;
                }
            }
            if(!found){
                break;
            }
        }
        if(found) return true;

        for(int n=1; n<=9; n++){
            if(isSafe(row,col,n,board)){
                board[row][col]=(char)(n+'0');
                if(solve(board)){
                    return true;
                }
                else{
                    board[row][col]='.';
                }
            }
        }
        return false;
    }
    public boolean isSafe(int r,int c,int num,char[][] board){
        //rowcheck
        for(int i=0; i<board.length; i++){
            if(board[r][i]==(char)(num+'0')) return false;
        }
        //colchcek
        for(int j=0; j<board.length; j++){
            if(board[j][c]==(char)(num+'0')) return false;
        }
        //grid check
        int sqrt=(int)Math.sqrt(board.length);
        int rowSt=r-r%sqrt;
        int colSt=c-c%sqrt;
        for(int i=rowSt; i<rowSt+sqrt; i++){
            for(int j=colSt; j<colSt+sqrt; j++){
                if(board[i][j]==(char)(num+'0')) return false;
            }
        }
        return true;

    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}