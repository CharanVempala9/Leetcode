class Solution {
    public int maxFreqSum(String s) {
        int[] freq=new int[26];
        int n=s.length();
        int v=0;
        int c=0;
        for(int i=0; i<n; i++){
            freq[s.charAt(i)-'a']++;
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'){
                v=Math.max(v,freq[s.charAt(i)-'a']);
            }
            else{
                c=Math.max(c,freq[s.charAt(i)-'a']);
            }
        }
        return c+v;
    }
}