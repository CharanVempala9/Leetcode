class Solution {
    public int numSub(String s) {
        long mod = 1000000007L;
        long cnt = 0, ans = 0;
        for (char c : s.toCharArray()) {
            if(c == '1') {
                cnt++;
                ans = (ans + cnt) % mod; 
            }else {
                cnt = 0;
            }
        }
        return (int) ans;
    }
}
