class Solution {
    public int minimumDeletions(String s) {
        Stack<Character>st=new Stack<>();
        int n=s.length();
        int cnt=0;
        for(int i=n-1; i>=0; i--){
            if(!st.isEmpty() && st.peek()=='a' && s.charAt(i)=='b'){
                cnt++;
                st.pop();
            }
            else st.push(s.charAt(i));
        }
        return cnt;
    }
}

/*  aababbab

    00011133

    44331111


*/