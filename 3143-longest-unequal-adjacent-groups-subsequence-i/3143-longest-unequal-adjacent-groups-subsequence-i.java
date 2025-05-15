class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n=words.length;
        List<String>ls=new ArrayList<>();
        int taken=-1;
        for(int i=0; i<n; i++){
            if(groups[i]!=taken){
                ls.add(words[i]);
                taken=groups[i];
            }
        }
        return ls;
    }
}