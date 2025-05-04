class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String,Integer>hm=new HashMap<>();
        String first=dominoes[0][0]+""+dominoes[0][1];
        hm.put(first,1);
        for(int i=1; i<dominoes.length; i++){
            String temp=dominoes[i][0]+""+dominoes[i][1];
            String rev = new StringBuilder(temp).reverse().toString();
            if(hm.containsKey(temp))
            hm.put(temp,hm.get(temp)+1);
            else if(hm.containsKey(rev))
            hm.put(rev,hm.get(rev)+1);
            else
            hm.put(temp,hm.getOrDefault(temp,0)+1);
        }
        int cnt=0;
        for(String s:hm.keySet()){
            if(hm.get(s)>1)
            cnt+=(hm.get(s)-1)*(hm.get(s))/2;
        }
        return cnt;
    }
}