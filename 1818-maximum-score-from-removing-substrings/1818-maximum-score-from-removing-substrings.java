class Solution {

    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return removePair(s, 'a', 'b', x, y);
        } else {
            return removePair(s, 'b', 'a', y, x);
        }
    }
    private int removePair(String s, char first, char second, int high, int low) {
        Stack<Character> stack = new Stack<>();
        int gain = 0;
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == first && c == second) {
                stack.pop();
                gain += high;
            } else {
                stack.push(c);
            }
        }
        StringBuilder remaining = new StringBuilder();
        for (char c : stack) {
            remaining.append(c);
        }
        stack.clear();
        for (char c : remaining.toString().toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == second && c == first) {
                stack.pop();
                gain += low;
            } else {
                stack.push(c);
            }
        }
        return gain;
    }
}
