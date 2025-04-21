class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> st = new Stack<>();

        for (String s : parts) {
            if (s.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else if (!s.equals("") && !s.equals(".")) {
                st.push(s);
            }
        }
        StringBuilder res = new StringBuilder();
        for (String dir : st) {
            res.append("/").append(dir);
        }

        return res.length() == 0 ? "/" : res.toString();
    }
}
