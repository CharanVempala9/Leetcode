class Solution {
    public int repeatedNTimes(int[] nums) {
        int n=nums.length;
        int f=n/2;
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int a:nums){
            hm.put(a,hm.getOrDefault(a,0)+1);
        }
        for(int v:hm.keySet()){
            if(hm.get(v)==f){
                return v;
            }
        }
        return -1;
    }
}