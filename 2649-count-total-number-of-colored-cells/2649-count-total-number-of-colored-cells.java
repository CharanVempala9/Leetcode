class Solution {
    public long coloredCells(int n) {
        if (n == 1) 
            return 1;
        long cnt = 1;
        for (int i = 2; i <= n; i++) {
            cnt += 4 * (i - 1); 
        }
        return cnt;
    }
}
