class Solution {
    public int calPoints(String[] operations) {
        int res=0;
        int n=operations.length;
        Stack<Integer>st=new Stack<>();
        for(int i=0; i<n; i++){
            String s=operations[i];
            if(s.equals("C")){
                st.pop();
            }
            else if(s.equals("D")){
                int ch=st.peek();
                st.push(2*ch);
            }
            else if(s.equals("+")){
                int ch=st.pop();
                int ch1=st.peek();
                st.push(ch);
                st.push(ch+ch1);
            }
            else{
                st.push(Integer.valueOf(s));
            }
        }
        while(!st.isEmpty()){
            res+=st.pop();
        }
        return res;
    }
}