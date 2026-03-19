class Solution {
    public int partitionString(String s) {
        int n=s.length();
        int cnt=1;
        HashSet<Character>hs=new HashSet<>();
        for(int i=0; i<n; i++){
            if(hs.contains(s.charAt(i))){
                cnt++;
                hs.clear();
            }
            hs.add(s.charAt(i));
        }
        return cnt;
    }
}