class Solution {
    public int concatenatedBinary(int n) {
        int mod = (int)1e9 + 7;
        int res = 0;
        for(int i = 1; i <= n; i++) {
            String tmp = Integer.toBinaryString(i);
            for(int j = 0; j < tmp.length(); j++) {
                int t = tmp.charAt(j) - '0';
                res = (res * 2 + t) % mod;
            }
        }
        return res;
    }
}