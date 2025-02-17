class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
        int n = s.length();
        for (int i = 0; i <= n - k; i++) {
            char currentChar = s.charAt(i);
            boolean isValid = true;
            for (int j = 1; j < k; j++) {
                if (s.charAt(i + j) != currentChar) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                if (i > 0 && s.charAt(i - 1) == currentChar) {
                    isValid = false;
                }
                if (i + k < n && s.charAt(i + k) == currentChar) {
                    isValid = false;
                }
                if (isValid) {
                    return true;
                }
            }
        }
        return false;
    }
}