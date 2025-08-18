class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>(wordDict);
        HashMap<String, Boolean> dp = new HashMap<>();
        return rec(s, hs, dp);
    }

    public boolean rec(String s, HashSet<String> hs, HashMap<String, Boolean> dp) {
        if (dp.containsKey(s)) return dp.get(s);
        if (hs.contains(s)) {
            dp.put(s, true);
            return true;
        }
        
        for (int i = 1; i <= s.length(); i++) {
            String pre = s.substring(0, i);
            if (hs.contains(pre) && rec(s.substring(i), hs, dp)) {
                dp.put(s, true);
                return true;
            }
        }
        
        dp.put(s, false);
        return false;
    }
}
