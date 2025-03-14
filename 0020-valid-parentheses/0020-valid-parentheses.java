class Solution {
    public boolean isValid(String s) {
        Stack<Character>st=new Stack<>();
        for(char ch:s.toCharArray()){
        if(ch=='(' || ch=='[' || ch=='{')
        st.push(ch);
        else{
            if(st.isEmpty())
            return false;
            char curr=st.pop();
            if((curr=='(' && ch!=')') || (curr=='{' && ch!='}') || (curr=='[' && ch!=']'))
            return false;
        }
        }
        return st.isEmpty();
    }
}