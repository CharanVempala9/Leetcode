import java.util.*;

class Solution {
    public boolean equalFrequency(String word) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char ch : word.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        for (char key : hm.keySet()) {
            hm.put(key, hm.get(key) - 1);
            HashSet<Integer> freqSet = new HashSet<>();
            for (int freq : hm.values()) {
                if (freq > 0) {
                    freqSet.add(freq);
                }
            }

            if (freqSet.size() == 1) {
                return true; 
            }

            hm.put(key, hm.get(key) + 1);
        }
        
        return false;
    }
}
