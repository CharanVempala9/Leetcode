class Solution {
    public boolean balanced(int[] f,int t){
        for(int i=0; i<26; i++){
            if(f[i]!=0 && f[i]!=t )return false;
        }
        return true;
    }
    public int longestBalanced(String s) {
        int n=s.length();
        int max=1;
        for(int i=0; i<n; i++){
            int[] arr=new int[26];
            arr[s.charAt(i)-'a']++;
            for(int j=i+1; j<n; j++){
                char ch=s.charAt(j);
                arr[ch-'a']++;
                if(balanced(arr,arr[s.charAt(j)-'a'])){
                    max=Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }
}