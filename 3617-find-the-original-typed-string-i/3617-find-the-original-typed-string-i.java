class Solution {
    public int possibleStringCount(String word) {
        int cnt=0;
        int n=word.length();
        for(int i=1; i<n; i++){
            if(word.charAt(i-1)==word.charAt(i)){
                cnt++;
            }
        }
        return cnt+1;
    }
}