class Solution {
    public String sortVowels(String s) {
        char[] arr={'A','E','I','O','U','a','e','i','o','u'};
        Set<Character>hs=new HashSet<>();
        for(char ch:arr){
            hs.add(ch);
        }
        int[] res=new int[53];
        for(int i=0; i<s.length(); i++){
            if(hs.contains(s.charAt(i))){
                res[(s.charAt(i)-0)-65]++;
            }
        }
        StringBuilder temp=new StringBuilder();
        for(int i=0; i<53; i++){
            int val=res[i];
            while(val-->0){
                temp.append((char)(i+65));
            }
        }
        int idx=0;
        StringBuilder ans=new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(!hs.contains(s.charAt(i))){
                ans.append(s.charAt(i));
            }
            else{
                ans.append(temp.charAt(idx));
                idx++;
            }
        }
        return ans.toString();
    }
}