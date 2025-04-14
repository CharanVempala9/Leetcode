class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> box = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                // Row check
                if (board[i][j] != '.') {
                    if (rows.contains(board[i][j])) return false;
                    rows.add(board[i][j]);
                }

                // Column check
                if (board[j][i] != '.') {
                    if (cols.contains(board[j][i])) return false;
                    cols.add(board[j][i]);
                }

                // Box check
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                char current = board[rowIndex + j / 3][colIndex + j % 3];
                if (current != '.') {
                    if (box.contains(current)) return false;
                    box.add(current);
                }
            }
        }
        return true;
    }
}
