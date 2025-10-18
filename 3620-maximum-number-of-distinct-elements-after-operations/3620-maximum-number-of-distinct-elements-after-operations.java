class Solution {
    public int poss(int val,int k,HashSet<Integer>hs,int st){
        st=Math.max(val-k,st);
        for(int i=st; i<=val+k; i++){
            if(!hs.contains(i)){
                return i;
            }
        }
        return Integer.MIN_VALUE;
        
    }
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int st=-k;
        HashSet<Integer>hs=new HashSet<>();
        for(int i=0; i<n; i++){
            int find=poss(nums[i],k,hs,st);
            if(find!=Integer.MIN_VALUE){
                st=find;
                hs.add(find);
            }
        }
        return hs.size();
    }
}