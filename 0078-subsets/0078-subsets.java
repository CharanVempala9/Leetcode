class Solution {
    public void generate(int idx,int[] nums,List<List<Integer>>ls,List<Integer>ans){
        if(idx==nums.length){
            ls.add(new ArrayList<>(ans));
            return;
        }
        //picking
        ans.add(nums[idx]);
        generate(idx+1,nums,ls,ans);
        //not pick
        ans.remove(ans.size()-1);
        generate(idx+1,nums,ls,ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ls=new ArrayList<>();
        generate(0,nums,ls,new ArrayList<>());
        return ls;
    }
} 