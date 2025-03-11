class Solution {
    public int numberOfSubstrings(String s) {
        int l = 0;
        int n = s.length();
        int ans = 0;
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int r = 0; r < n; r++) {
            char ch = s.charAt(r);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
            while (hm.containsKey('a') && hm.containsKey('b') && hm.containsKey('c')) {
                ans += n - r; 
                char c = s.charAt(l);
                if (hm.get(c) > 1) {
                    hm.put(c, hm.get(c) - 1);
                } else {
                    hm.remove(c);
                }
                l++;
            }
        }

        return ans;
    }
}
