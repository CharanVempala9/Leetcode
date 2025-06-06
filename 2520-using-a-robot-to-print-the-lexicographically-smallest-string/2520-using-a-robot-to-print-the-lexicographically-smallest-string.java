import java.util.*;

class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        StringBuilder res = new StringBuilder(); 
        StringBuilder t = new StringBuilder();   
        char[] minChar = new char[n];
        minChar[n - 1] = s.charAt(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            minChar[i] = (char) Math.min(s.charAt(i), minChar[i + 1]);
        }

        int i = 0;
        while (i < n) {
            char ch = s.charAt(i);
            res.append(ch);
            while (res.length() > 0 && res.charAt(res.length() - 1) <= minChar[i == n - 1 ? i : i + 1]) {
                t.append(res.charAt(res.length() - 1));
                res.deleteCharAt(res.length() - 1);
            }

            i++;
        }
        int rem = res.length() - 1;
        while (rem >= 0) {
            t.append(res.charAt(rem));
            rem--;
        }

        return t.toString();
    }
}
