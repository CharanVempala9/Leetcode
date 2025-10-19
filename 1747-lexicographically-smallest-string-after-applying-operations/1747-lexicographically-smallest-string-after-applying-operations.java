class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        HashSet<String> hs = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        hs.add(s);
        String minStr = s;
        while (!q.isEmpty()) {
            String t = q.poll();
            if (t.compareTo(minStr) < 0) {
                minStr = t;
            }
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < t.length(); i++) {
                if (i % 2 == 1) {
                    int val = (t.charAt(i) - '0' + a) % 10;
                    res.append((char)(val + '0'));
                } else {
                    res.append(t.charAt(i));
                }
            }
            String addOp = res.toString();
            if (!hs.contains(addOp)) {
                hs.add(addOp);
                q.add(addOp);
            }
            String rotateOp = t.substring(t.length() - b) + t.substring(0, t.length() - b);
            if (!hs.contains(rotateOp)) {
                hs.add(rotateOp);
                q.add(rotateOp);
            }
        }
        return minStr;
    }
}
