class Solution {
    public String mergeAlternately(String word1, String word2) {
        int l1=word1.length();
        int l2=word2.length();
        int i1=0;
        StringBuilder res=new StringBuilder();
        int i2=0;
        while(i1<l1 && i2<l2){
            char ch=word1.charAt(i1);
            char ch2=word2.charAt(i2);
            res.append(ch);
            res.append(ch2);
            i1++;
            i2++;
        }
        while(i1<l1){
            char ch=word1.charAt(i1);
            res.append(ch);
            i1++;
        }
        while(i2<l2){
            char ch=word2.charAt(i2);
            res.append(ch);
            i2++;
        }
        return res.toString();
    }
}