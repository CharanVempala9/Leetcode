class Solution {
    public String clearStars(String s) {
        int n = s.length();
        PriorityQueue<Character> charQueue = new PriorityQueue<>();
        Map<Character, Deque<Integer>> charMap = new HashMap<>();
        boolean[] keep = new boolean[n];
        Arrays.fill(keep, true);

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '*') {
                if (!charQueue.isEmpty()) {
                    char smallest = charQueue.peek();
                    int indexToRemove = charMap.get(smallest).removeLast();
                    keep[i] = false;
                    keep[indexToRemove] = false;
                    charQueue.remove(smallest);
                } else {
                    keep[i] = false;
                }
            } else {
                charQueue.offer(c);
                charMap.putIfAbsent(c, new ArrayDeque<>());
                charMap.get(c).add(i);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (keep[i]) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
