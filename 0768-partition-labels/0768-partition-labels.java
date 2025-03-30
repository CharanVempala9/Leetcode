import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] arr = new int[26]; 
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] = i;
        }

        List<Integer> ls = new ArrayList<>();
        int maxLast = 0;
        int partitionStart = 0;

        for (int i = 0; i < s.length(); i++) {
            maxLast = Math.max(maxLast, arr[s.charAt(i) - 'a']);
            if (i == maxLast) {
                ls.add(i - partitionStart + 1);
                partitionStart = i + 1;
            }
        }

        return ls;
    }
}
