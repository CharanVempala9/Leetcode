import java.util.*;

class Solution {
    public String lexSmallest(String s) {
        int n = s.length();
        Set<String> seen = new HashSet<>();
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String part1 = s.substring(0, i);
            String part2 = s.substring(i);
            String res1 = part1 + new StringBuilder(part2).reverse();
            if (seen.add(res1)) ls.add(res1);
            String res2 = new StringBuilder(part1).reverse() + part2;
            if (seen.add(res2)) ls.add(res2);
        }
        Collections.sort(ls);
        return ls.get(0);
    }
}
