class Solution {
    public int minDeletionSize(String[] strs) {
        int n=strs[0].length();
        int m=strs.length;
        int cnt=0;
        for(int i=0; i<n; i++){
            for(int j=1; j<m; j++){
                if(strs[j-1].charAt(i)>strs[j].charAt(i)){
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }
}