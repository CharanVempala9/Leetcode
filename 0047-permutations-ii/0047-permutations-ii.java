class Solution {
    public void generate(int[] nums,int idx,Set<List<Integer>>hs,List<Integer>ans){
        if(idx==nums.length){
            hs.add(new ArrayList<>(ans));
            return;
        }
        int val=nums[idx];
        for(int i=0; i<=ans.size(); i++){
            ArrayList<Integer>temp=new ArrayList<>(ans);
            temp.add(i,val);
            generate(nums,idx+1,hs,temp);

        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>>ls=new HashSet<>();
        generate(nums,0,ls,new ArrayList<>());
        return new ArrayList<>(ls);
    }
}