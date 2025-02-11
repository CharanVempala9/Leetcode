class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder res=new StringBuilder();
        int n=part.length();
        for(int i=0; i<s.length(); i++){
            res.append(s.charAt(i));
            if(res.toString().contains(part)){
                int temp=n;
                while(temp!=0){
                    res.deleteCharAt(res.length()-1);
                    temp--;
                }
            }
        }
        return res.toString();
    }
}