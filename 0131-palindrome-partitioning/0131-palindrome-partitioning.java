class Solution {
    public void generate(List<List<String>> ls, List<String> path, String s, int idx) {
        if (idx == s.length()) {
            ls.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx + 1; i <= s.length(); i++) {
            String prefix = s.substring(idx, i);
            if (isPalindrome(prefix)) {
                path.add(prefix);
                generate(ls, path, s, i);
                path.remove(path.size() - 1); // backtrack
            }
        }
    }

    public boolean isPalindrome(String p) {
        int l = 0, r = p.length() - 1;
        while (l < r) {
            if (p.charAt(l++) != p.charAt(r--)) return false;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ls = new ArrayList<>();
        generate(ls, new ArrayList<>(), s, 0);
        return ls;
    }
}
