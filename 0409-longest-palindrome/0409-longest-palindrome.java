class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer>hm=new HashMap<>();
        int n=s.length();
        for(int i=0; i<n; i++){
            char ch=s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        int cnt=0;
        boolean found=false;
        for(char val:hm.keySet()){
            if(hm.get(val)%2==0)
            cnt+=hm.get(val);
            else{
                cnt+=hm.get(val)-1;
                found=true;
            }
        }
        if(found)
        return cnt+1;
        return cnt;
    }
}