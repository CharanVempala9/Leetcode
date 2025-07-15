class Solution {
    public boolean isValid(String word) {
        word=word.toLowerCase();
        int vowel=0;
        int cons=0;
        int ch=0;
        for(char s:word.toCharArray()){
            if(!Character.isLetterOrDigit(s)){
                return false;
            }
            if(s>='a' && s<='z' ){
                ch++;
                if(s=='a' || s=='e' || s=='i' || s=='o' || s=='u'){
                    vowel++;
                }
                else{
                    cons++;
                }
            }
            else if(s>='0' && s<='9')
            ch++;
        }
        System.out.println(cons+" "+vowel+" "+ch);
        if(cons>0 && vowel>0 && ch>2){
        return true;
        }
        else
        return false;
    }
}