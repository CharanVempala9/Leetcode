class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer,Integer>hm=new  HashMap<>();
        int n=basket1.length;
        for(int val:basket1){
            hm.put(val, hm.getOrDefault(val,0)+1);
        }
        for(int val:basket2){
            hm.put(val,hm.getOrDefault(val,0)-1);
        }
        ArrayList<Integer>ls=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        for(int val:hm.keySet()){
            int temp=Math.abs(hm.get(val));
            if(temp % 2== 1)  return -1;
            if(temp > 0){
                for(int i=0; i< temp /2 ; i++){
                    ls.add(val);
                }
            }
            min=Math.min(min, val);
        }
        Collections.sort(ls);
        long ans=0;
        for(int i=0; i<ls.size()/2; i++){
            ans+=Math.min(2*min, ls.get(i));
        }
        return ans;
        
    }
}