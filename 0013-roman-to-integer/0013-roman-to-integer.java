class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer>hm=new HashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);
        int ans=0;
        int prev=0;
        for(int i=s.length()-1; i>=0; i--){
            int curr=hm.get(s.charAt(i));
            if(curr<prev){
                ans-=curr;
            }
            else{
                ans+=curr;
            }
            prev=curr;
        }
        return ans;
    }
}