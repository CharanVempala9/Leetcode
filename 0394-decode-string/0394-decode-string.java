class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch != ']') {
                st.push(ch);
            } else {
                StringBuilder temp = new StringBuilder();
                while (!st.isEmpty() && st.peek() != '[') {
                    temp.insert(0, st.pop()); 
                }
                st.pop(); 
                
                StringBuilder numStr = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    numStr.insert(0, st.pop());
                }
                int num = Integer.parseInt(numStr.toString());
                
                String repeated = temp.toString().repeat(num);
                for (char c : repeated.toCharArray()) {
                    st.push(c);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.insert(0, st.pop());
        }
        
        return res.toString();
    }
}
