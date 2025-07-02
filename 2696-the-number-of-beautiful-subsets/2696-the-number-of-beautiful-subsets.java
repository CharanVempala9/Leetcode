class Solution {
    public int generate(int[] nums,int idx,int k,ArrayList<Integer>ls){
        if(idx==nums.length){
            if(isposs(ls,k)){
                return 1;
            }
            return 0;
        }
        int val=nums[idx];
        //take it
        int cnt=0;
        ls.add(val);
        cnt+=generate(nums,idx+1,k,ls);
        //not take it;
        ls.remove(ls.size()-1);
        cnt+=generate(nums,idx+1,k,ls);


        return cnt;
    }
    public static boolean isposs(ArrayList<Integer>ls,int k){
        HashSet<Integer>hs=new HashSet<>();
        for(int i=0; i<ls.size(); i++){
            int val=ls.get(i);
            if(hs.contains(val-k) || hs.contains(val+k)){
                return false;
            }
            hs.add(val);
        }
        return true;
    }
    public int beautifulSubsets(int[] nums, int k) {
        ArrayList<Integer>ls=new ArrayList<>();
        return generate(nums,0,k,ls)-1;
    }
}