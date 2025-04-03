class Solution {
    public int evalRPN(String[] tokens) {
        int n=tokens.length;
        Stack<Integer>st=new Stack<>();
        for(int i=0; i<n; i++){
            String s=tokens[i];
            if(!s.equals("+") &&  !s.equals("-") && !s.equals("/") && !s.equals("*")){
                st.push(Integer.parseInt(s));
            }
            else{
                if(s.equals("+")){
                    if(!st.isEmpty() && st.size()>1){
                        int val1=st.pop();
                        int val2=st.pop();
                        int ans=val1+val2;
                        st.push(ans);
                    }
                }
                else if(s.equals("-")){
                    if(!st.isEmpty() && st.size()>1){
                        int val1=st.pop();
                        int val2=st.pop();
                        int ans=val2-val1;
                        st.push(ans);
                    }
                }
                else if(s.equals("*")){
                    if(!st.isEmpty() && st.size()>1){
                        int val1=st.pop();
                        int val2=st.pop();
                        int ans=val1*val2;
                        st.push(ans);
                    }
                }
                else{
                    if(!st.isEmpty() && st.size()>1){
                        int val1=st.pop();
                        int val2=st.pop();
                        int ans=val2/val1;
                        st.push(ans);
                    }
                }
            }
        }
        return st.pop();
    }
}