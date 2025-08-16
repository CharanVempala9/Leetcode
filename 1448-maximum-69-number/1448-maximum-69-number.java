class Solution {
    public int maximum69Number (int num) {
        String ans=String.valueOf(num);
        StringBuilder res=new StringBuilder();
        int n=ans.length();
        int idx=-1;
        for(int i=0; i<n; i++){
            if(ans.charAt(i)=='6' && idx==-1){
                res.append('9');
                idx++;
            }
            else{
                res.append(ans.charAt(i));
            }
        }
        return Integer.parseInt(res.toString());
    }
}