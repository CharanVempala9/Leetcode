class Solution {
    HashMap<String, List<Character>> mp = new HashMap<>();
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String s : allowed) {
            String key = s.substring(0, 2);
            char val = s.charAt(2);
            mp.computeIfAbsent(key, k -> new ArrayList<>()).add(val);
        }
        return dfs(bottom, "");
    }
    private boolean dfs(String cur, String next) {
        if (cur.length() == 1) return true;
        if (next.length() + 1 == cur.length()) {
            return dfs(next, "");
        }
        int idx = next.length();
        String key = cur.substring(idx, idx + 2);
        if (!mp.containsKey(key)) return false;
        for (char ch : mp.get(key)) {
            if (dfs(cur, next + ch)) return true;
        }
        return false;
    }
}
