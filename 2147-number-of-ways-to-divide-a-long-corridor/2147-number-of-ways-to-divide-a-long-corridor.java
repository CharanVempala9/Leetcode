class Solution {
    public int numberOfWays(String s) {
        int mod = 1000000007;
        int n = s.length();
        ArrayList<Integer> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'S') {
                ls.add(i);
            }
        }
        int cnt = ls.size();
        if (cnt == 0 || cnt % 2 == 1) return 0;
        if (cnt == 2) return 1;
        long ans = 1;
        for (int i = 2; i < cnt; i += 2) {
            ans = (ans * (ls.get(i) - ls.get(i - 1))) % mod;
        }
        return (int) ans;
    }
}
