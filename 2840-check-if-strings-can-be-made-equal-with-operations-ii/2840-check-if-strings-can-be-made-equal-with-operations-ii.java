class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n=s1.length();
        int[] freqS1=new int[26];
        int[] freqS2=new int[26];
        for(int i=0; i<n; i+=2){
            freqS1[s1.charAt(i)-'a']++;
        }
        for(int i=0; i<n; i+=2){
            freqS1[s2.charAt(i)-'a']--;
        }
        for(int i=1; i<n; i+=2){
            freqS2[s2.charAt(i)-'a']++;
        }
        for(int i=1; i<n; i+=2){
            freqS2[s1.charAt(i)-'a']--;
        }
        for(int i=0; i<26; i++){
            if(freqS1[i]!=0 || freqS2[i]!=0){
                return false;
            }
        }
        return true;
    }
}