class Solution {
    public boolean solve(char[][] board){
        int row=-1;
        int col=-1;
        int n=board.length;
        boolean found=true;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
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
        if(found)
        return true;

        //backtrack
        for(int num=1; num<=9; num++){
            if(isSafe(board,row,col,num)){
                board[row][col]=(char)(num+'0');
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
    public boolean isSafe(char[][] board,int r,int c,int num){
        //row check
        int n=board.length;
        for(int i=0; i<n; i++){
            if(board[r][i]==(char)num+'0'){
                return false;
            }
        }
        //col check
        for(int i=0; i<n; i++){
            if(board[i][c]==(char)num+'0'){
                return false;
            }
        }
        //  grid check
        int sqrt=(int)Math.sqrt(board.length);
        int rStart= r-r%sqrt;
        int cStart=c-c%sqrt;
        for(int i=rStart; i<rStart+sqrt; i++){
            for(int j=cStart; j<cStart+sqrt; j++){
                if(board[i][j]==(char)num+'0'){
                    return false;
                }
            }
        }
        //if not satisfied all these conditions
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }
}