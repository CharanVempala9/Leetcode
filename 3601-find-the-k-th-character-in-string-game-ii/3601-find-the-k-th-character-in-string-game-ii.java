class Solution {
    public char kthCharacter(long k, int[] operations) {
        k -= 1; 
        int res = 0;

        for (int i = 0; i < operations.length && i < 60; ++i) {
            if (((k >> i) & 1) == 1) {
                res += operations[i];
            }
        }
        return (char)('a' + res % 26);
    }
}