class Solution {
    public void generate(String p, String up,List<String>res){
        if(up.isEmpty()){
            res.add(p);
            return;
        }
        int digit=up.charAt(0)-'0';
        String[] letters={"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String letter=letters[digit];
        for(int i=0; i<letter.length(); i++){
            char ch=letter.charAt(i);
            generate(p+ch,up.substring(1),res);
        }
    }
    public List<String> letterCombinations(String digits) {
        ArrayList<String>res=new ArrayList<>();
        if (digits.isEmpty()) return res; 
        generate("",digits,res);
        return res;
    }
}