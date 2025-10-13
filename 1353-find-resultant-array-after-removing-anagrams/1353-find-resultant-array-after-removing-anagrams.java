class Solution {
    public boolean isPoss(String s1,String s2){
        if(s1.length()!=s2.length())return false;
        int[] arr=new int[26];
        for(int i=0; i<s1.length(); i++){
            arr[s1.charAt(i)-'a']++;
        }
        for(int i=0; i<s2.length(); i++){
            arr[s2.charAt(i)-'a']--;
        }
        for(int i=0; i<26; i++){
            if(arr[i]!=0)return false;
        }
        return true;
    }
    public List<String> removeAnagrams(String[] words) {
        List<String>ls=new ArrayList<>();
        ls.add(words[0]);
        for(int i=1; i<words.length; i++){
            if(isPoss(ls.get(ls.size()-1),words[i])){
                continue;
            }
            else{
                ls.add(words[i]);
            }
        }
        return ls;
    }
}