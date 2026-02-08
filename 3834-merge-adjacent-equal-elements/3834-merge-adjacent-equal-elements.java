class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        List<Long>ls=new ArrayList<>();
        int n=nums.length;
        ls.add((long)nums[0]);
        for(int i=1; i<n; i++){
            ls.add((long)nums[i]);
            int size=ls.size();
            while(size>1 && ls.get(size-1).equals(ls.get(size-2))){
                long tmp2=ls.get(size-1)*2;
                ls.set(ls.size()-2,tmp2);
                ls.remove(ls.size()-1);
                size=ls.size();
            }
        }
        return ls;

    }
}