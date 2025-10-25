class Solution {
    public int totalMoney(int n) {
        int idx = 1; 
        int ans = 0; 
        int st = 1; 
        int cnt = 1;

        while (cnt <= n) {
            ans += st;
            System.out.println(ans);
            st++;
            if (cnt % 7 == 0) { 
                idx++;
                st = idx; 
            }
            cnt++;
        }
        return ans;
    }
}
