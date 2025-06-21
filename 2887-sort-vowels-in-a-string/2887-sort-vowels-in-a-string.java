import java.util.*;

class Solution {
    public String sortVowels(String s) {
        List<Character> vowelsList = new ArrayList<>();
        Set<Character> vowelsSet = Set.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
        for (char ch : s.toCharArray()) {
            if (vowelsSet.contains(ch)) {
                vowelsList.add(ch);
            }
        }
        Collections.sort(vowelsList);
        StringBuilder result = new StringBuilder();
        int vowelIndex = 0;
        for (char ch : s.toCharArray()) {
            if (vowelsSet.contains(ch)) {
                result.append(vowelsList.get(vowelIndex++));
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
