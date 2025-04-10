class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int n1 = strs[0].length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n1; i++) {
            if (strs[0].length() <= i) break;
            char ch = strs[0].charAt(i);
            boolean matched = true;
            for (int j = 1; j < n; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != ch) {
                    matched = false;
                    break;
                }
            }
            if (matched) {
                res.append(ch);
            } else {
                break;
            }
        }
        return res.toString();
    }
}
