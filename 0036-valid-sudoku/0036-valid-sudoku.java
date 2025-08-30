class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            HashSet<Character>row=new HashSet<>();
            HashSet<Character>col=new HashSet<>();
            HashSet<Character>curr=new HashSet<>();
            
            for(int j=0; j<9; j++){
                //rowcheck
                if(board[i][j]!='.'){
                    if(row.contains(board[i][j])) return false;
                    row.add(board[i][j]);
                }
                //colcheck
                if(board[j][i]!='.'){
                    if(col.contains(board[j][i])) return false;
                    col.add(board[j][i]);
                }
                //grid check
                int rowidx = 3*(i/3);
                int colidx = 3*(i%3);
                char c=board[rowidx + j/3][colidx + j%3];
                if(c!='.'){
                    if(curr.contains(c)) return false;
                    curr.add(c);
                }

            }
        }
        return true;
    }
}