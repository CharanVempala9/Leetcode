class Solution {
    public static List<List<String>> queens(boolean[][] board,int r){
        if(r==board.length){
            List<List<String>>ans=new ArrayList<>();
            ans.add(display(board));
            return ans;
        }
        List<List<String>>res=new ArrayList<>();
        for(int c=0; c<board.length; c++){
            if(isSafe(board,r,c)){
                board[r][c]=true;
                res.addAll(queens(board,r+1));
                board[r][c]=false;
            }
        }
        return res;
    }
    public static boolean isSafe(boolean[][] board,int r,int c){
        //vertical
        for(int i=0; i<r; i++){
            if(board[i][c]){
                return false;
            }
        }
        //diagonal left
        int maxLeft=Math.min(r,c);
        for(int i=1; i<=maxLeft; i++){
            if(board[r-i][c-i]){
                return false;
            }
        }
        //diagonal right
        int maxRight=Math.min(r,board.length-c-1);
        for(int i=1; i<=maxRight; i++){
            if(board[r-i][c+i]){
                return false;
            }
        }
        //if not placed
        return true;
    }
    public static List<String> display(boolean[][] board){
        List<String>ls=new ArrayList<>();
        for(int i=0; i<board.length; i++){
            StringBuilder res=new StringBuilder();
            for(int j=0; j<board.length; j++){
                if(board[i][j])
                res.append("Q");
                else
                res.append(".");
            }
            ls.add(res.toString());
        }
        return ls;
    }
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board=new boolean[n][n];
        List<List<String>>ls=queens(board,0);
        return ls;
    }
}