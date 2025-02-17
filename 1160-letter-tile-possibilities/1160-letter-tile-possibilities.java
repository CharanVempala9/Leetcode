import java.util.HashMap;

class Solution {
    public int numTilePossibilities(String tiles) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : tiles.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        return countSequences(freq);
    }

    private int countSequences(HashMap<Character, Integer> freq) {
        int count = 0;
        for (char c : freq.keySet()) {
            if (freq.get(c) > 0) { 
                count++;
                freq.put(c, freq.get(c) - 1); 
                count += countSequences(freq); 
                freq.put(c, freq.get(c) + 1); 
            }
        }
        return count;
    }
}
