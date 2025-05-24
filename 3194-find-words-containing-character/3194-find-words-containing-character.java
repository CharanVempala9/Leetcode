class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer>ls=new ArrayList<>();
        int n=words.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<words[i].length(); j++){
                if(words[i].charAt(j)==x){
                    ls.add(i);
                    break;
                }
            }
            
        }
        return ls;
    }
}