class Solution {
    public String clearDigits(String s) {
        StringBuilder res= new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                res.deleteCharAt(res.length()-1);
            }
            else{
                res.append(ch);
            }
        }
        return res.toString();
        
    }
}