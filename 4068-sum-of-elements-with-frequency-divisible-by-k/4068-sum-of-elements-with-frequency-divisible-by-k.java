class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int n:nums){
            hm.put(n,hm.getOrDefault(n,0)+1);
        }
        int sum=0;
        for(int val:hm.keySet()){
            int f=hm.get(val);
            if(f%k==0){
                sum+=val*f;
            }
        }
        return sum;
    }
}