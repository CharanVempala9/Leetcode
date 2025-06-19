class Solution {
    public String decodeString(String s) {
        StringBuilder curr = new StringBuilder();
        Stack<StringBuilder> stack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        int k = 0;

        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k*10 + (c-'0');
                continue;
            }
            if (Character.isLetter(c)) {
                curr.append(c);
                continue;
            }
            if (c == '[') {
                stack.push(curr);
                countStack.push(k);
                k = 0;
                curr = new StringBuilder();
            }
            if (c == ']') {
                int times = countStack.pop();
                StringBuilder prefix = stack.pop();
                while (times>0) {
                    prefix.append(curr);
                    times--;
                }
                curr = prefix;
            }
        }
        return curr.toString();
    }
}