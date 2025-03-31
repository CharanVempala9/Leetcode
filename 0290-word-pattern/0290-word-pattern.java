import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> hm = new HashMap<>();
        HashMap<String, Character> reverseMap = new HashMap<>();
        
        String[] arr = s.split(" ");
        
        if (pattern.length() != arr.length) {
            return false;
        }
        
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = arr[i];

            if (hm.containsKey(ch)) {
                if (!hm.get(ch).equals(word)) {
                    return false; 
                }
            } else {
                if (reverseMap.containsKey(word)) {
                    return false;
                }
                hm.put(ch, word);
                reverseMap.put(word, ch);
            }
        }
        return true;
    }
}
