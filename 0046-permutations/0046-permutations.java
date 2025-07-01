class Solution {
    public void generate(int idx, int[] nums,List<List<Integer>>ls,List<Integer>ans){
        if(idx==nums.length){
            ls.add(new ArrayList<>(ans));
            return;
        }
        int num=nums[idx];
        for(int i=0; i<=ans.size(); i++){
            ArrayList<Integer>temp=new ArrayList<>(ans);
            temp.add(i,num);
            generate(idx+1,nums,ls,temp);

        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ls=new ArrayList<>();
        generate(0,nums,ls,new ArrayList<>());
        return ls;
    }
}